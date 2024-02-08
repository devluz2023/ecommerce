#!/bin/bash

folder="ks-configuration"

kubectl apply -f "$folder/cluster-user.yaml"
kubectl apply -f "$folder/config-map.yaml"
kubectl apply -f "$folder/gateway.yaml"
kubectl apply -f "$folder/gateway-service.yaml"
kubectl apply -f "$folder/ingress.yaml"
kubectl apply -f "$folder/postgres.yaqml"
kubectl apply -f "$folder/postgres-service.yaml"
kubectl apply -f "$folder/product-api.yaml"
kubectl apply -f "$folder/product-api-service.yaml"
kubectl apply -f "$folder/shopping-api.yaml"
kubectl apply -f "$folder/shopping-api-service.yaml"
kubectl apply -f "$folder/user-api.yaml"
kubectl apply -f "$folder/user-api-service.yaml"
