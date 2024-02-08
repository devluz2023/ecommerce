#!/bin/bash

# Define the ACR login server
acr_login_server="acrappfaluz3.azurecr.io"
version="v1"
# Define the source image tags
shopping_api="loja/shopping-api:latest"
product_api="loja/product-api:latest"
gateway="loja/gateway:latest"
user_api="loja/user-api:latest"
postgres="postgres:latest"

# Define the target image tags
target_shopping_api_tag="$acr_login_server/shoppingapi:$version"
target_product_api_tag="$acr_login_server/productapi:$version"
target_gateway_tag="$acr_login_server/gateway:$version"
target_user_api_tag="$acr_login_server/userapi:$version"
target_postgres_tag="$acr_login_server/postgres:$version"

# Tag the server image
docker tag "$shopping_api" "$target_shopping_api_tag"
docker tag "$product_api" "$target_product_api_tag"
docker tag "$gateway" "$target_gateway_tag"
# Tag the web image
docker tag "$user_api" "$target_user_api_tag"
docker tag "$postgres" "$target_postgres_tag"

# Push the tagged images to the ACR
docker push "$target_shopping_api_tag"
docker push "$target_product_api_tag"
docker push "$target_gateway_tag"
docker push "$target_user_api_tag"
docker push "$target_postgres_tag"

