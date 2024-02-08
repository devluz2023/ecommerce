#!/bin/bash

# Define the ACR login server
acr_login_server="acrappfaluz3.azurecr.io"
version="v1"

user_api="loja/user-api:latest"


# Define the target image tags

target_user_api_tag="$acr_login_server/userapi:$version"

docker tag "$user_api" "$target_user_api_tag"

docker push "$target_user_api_tag"


