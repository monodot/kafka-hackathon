# kafka-hackathon
Kafkaaaaaaaaaaaaaaaaaaaa. London. 2017. December.

## Deploy using barnabas (enmasse project)

Using the `openshift-template` from the Barnabas project:

    curl -OL https://raw.githubusercontent.com/EnMasseProject/barnabas/0.1.0-rc1/kafka-statefulsets/resources/openshift-template.yaml

Then to run in OpenShift:

```
oc new-project barnabas
oc create -f barnabas/openshift-template.yaml
oc new-app barnabas
```

## Camel client

A demo client written in Apache Camel using Spring Boot.

The project was initially created using:

    $ spring init -d=camel -g=com.cleverbuilder.kafkademos -a=camel-kafka-client camel-kafka-client

Then deployed into OpenShift (upstreamy):

    $ oc create -f https://raw.githubusercontent.com/fabric8io-images/s2i/master/image-streams.json
    $ oc new-app fuse-java~https://github.com/monodot/kafka-hackathon --context-dir=camel-kafka-producer --labels=app=camel-kafka-producer --name=camel-kafka-producer
    $ oc new-app fuse-java~https://github.com/monodot/kafka-hackathon --context-dir=camel-kafka-consumer --labels=app=camel-kafka-consumer --name=camel-kafka-consumer

Or OpenShift Container Platform (enterprisey officey):

    $ oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/master/fis-image-streams.json
    $ oc new-app fis-java-openshift~https://github.com/monodot/kafka-hackathon --context-dir=camel-kafka-producer --labels=app=camel-kafka-producer --name=camel-kafka-producer
    $ oc new-app fis-java-openshift~https://github.com/monodot/kafka-hackathon --context-dir=camel-kafka-consumer --labels=app=camel-kafka-consumer --name=camel-kafka-consumer
