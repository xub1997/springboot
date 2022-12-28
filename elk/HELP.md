# ELK Docker Compose
```shell script
version: '3'
services:
  elasticsearch:
    image: elasticsearch:7.6.0
    container_name: elasticsearch
    environment:
      - "cluster.name=elasticsearch" #设置集群名称为elasticsearch
      - "discovery.type=single-node" #以单一节点模式启动
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m" #设置使用jvm内存大小
    volumes:
      #配置文件
      - $PWD/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml 
      # 插件文件挂载
      - $PWD/elasticsearch/plugins:/usr/share/elasticsearch/plugins 
      # 数据文件挂载
      - $PWD/elasticsearch/data:/usr/share/elasticsearch/data 
    ports:
      - 9200:9200
      - 9300:9300 
  kibana:
    image: kibana:7.6.0
    container_name: kibana
    depends_on:
      - elasticsearch #kibana在elasticsearch启动之后再启动
    environment:
      - ELASTICSEARCH_URL=http://elasticsearch:9200 #设置访问elasticsearch的地址
    volumes:
      #配置文件
      - $PWD/kibana/config/kibana.yml:/usr/share/kibana/config/kibana.yml
    ports:
      - 5601:5601
  logstash:
    image: logstash:7.6.0
    container_name: logstash
    volumes:
      - $PWD/logstash/config/logstash.yml:/usr/share/logstash/config/logstash.yml
      - $PWD/logstash/pipeline:/usr/share/logstash/pipeline
    depends_on:
      - elasticsearch #kibana在elasticsearch启动之后再启动
    ports:
      - 5144:5144
```
# elasticsearch.yml
```yaml
cluster.name: "elasticsearch"
network.host: 0.0.0.0
# 访问ID限定，0.0.0.0为不限制，生产环境请设置为固定IP
transport.host: 0.0.0.0
# 下面的配置是关闭跨域验证（可以不开启）
http.cors.enabled: true
http.cors.allow-origin: "*"
```
# kibana.yml
```yaml
server.port: 5601
server.host: "0.0.0.0"
elasticsearch.hosts: ["http://es IP:9200"]
# 操作界面语言设置为中文
i18n.locale: "zh-CN"
```
# logstash.yml
```yaml
http.host: "0.0.0.0"
xpack.monitoring.enabled: true
xpack.monitoring.elasticsearch.hosts: [ "http://es IP:9200" ]
```
# springboot-elk.conf
```yaml
input {
  tcp {
    mode => "server"
    host => "0.0.0.0"
    port => 5144
    codec => json_lines
  }
}
output {
  elasticsearch {
    hosts => "es IP:9200"
    index => "springboot-elk-%{+YYYY.MM.dd}"
  }
}
```
文件地址：
链接: https://pan.baidu.com/s/1nXagTju4A6xHhy8-ku2y2w 提取码: f85i 
