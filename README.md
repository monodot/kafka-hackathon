# kafka-hackathon
Kafkaaaaaaaaaaaaaaaaaaaa

## barnabas

Using the `openshift-template` from the Barnabas project:

    curl -OL https://raw.githubusercontent.com/EnMasseProject/barnabas/0.1.0-rc1/kafka-statefulsets/resources/openshift-template.yaml

Then to run in OpenShift:

```
oc new-project barnabas
oc create -f barnabas/openshift-template.yaml
oc new-app barnabas
```

## Camel client


