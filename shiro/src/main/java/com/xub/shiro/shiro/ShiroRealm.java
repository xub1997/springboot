package com.xub.shiro.shiro;


import com.xub.shiro.core.entity.TbSysPermission;
import com.xub.shiro.core.entity.TbSysRole;
import com.xub.shiro.core.entity.TbSysUser;
import com.xub.shiro.core.service.ITbSysPermissionService;
import com.xub.shiro.core.service.ITbSysRoleService;
import com.xub.shiro.core.service.ITbSysUserService;
import com.xub.shiro.enums.AccountEnum;
import com.xub.shiro.utils.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description Shiro权限匹配和账号密码匹配
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ITbSysUserService sysUserService;

    @Autowired
    private ITbSysRoleService sysRoleService;

    @Autowired
    private ITbSysPermissionService sysPermissionService;

    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户ID
        TbSysUser sysUserEntity = (TbSysUser) principalCollection.getPrimaryPrincipal();
        String userId = sysUserEntity.getId();
        //查询角色和权限
        List<TbSysRole> sysRoleEntityList = sysRoleService.selectSysRoleByUserId(userId);
        //对应角色
        Set<String> rolesSet = sysRoleEntityList.stream()
                .map(TbSysRole::getRoleName)
                .collect(Collectors.toSet());
        //对应权限
        List<TbSysPermission> sysPermissionEntityList = sysPermissionService.selectSysPermissionByUserId(userId);
        Set<String> permsSet = sysPermissionEntityList.stream()
                .map(TbSysPermission::getPermissionCode)
                .collect(Collectors.toSet());
        //将查到的权限和角色分别传入authorizationInfo中
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //角色
        authorizationInfo.setRoles(rolesSet);
        //权限
        authorizationInfo.setStringPermissions(permsSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        TbSysUser user = sysUserService.selectUserByName(username);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结（1 正常使用  2禁用  3停止使用）
        if (!AccountEnum.NORMAL.getCode().equals(user.getIsUsed())) {
            throw new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,                                  //用户名
                user.getPwd(),                    //密码
                ByteSource.Util.bytes(user.getSalt()), //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtil.deleteCache(username, true);
        return authenticationInfo;
    }
}
