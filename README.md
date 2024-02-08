# loja
springboot

# to run postgres
`docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres`


# microservico

4. Run terraform output to get the SSH private key and save it to a file.
   `terraform output -raw tls_private_key > id_rsa`
5. Run terraform output to get the virtual machine public IP address.
   `terraform output public_ip_address`
6. Permission key
   `chmod 600 id_rsa`
7. Use SSH to connect to the virtual machine.
   `ssh -i id_rsa azureuser@<public_ip_address>`
8. Generate ssh key
   `ssh-keygen -t rsa -b 4096 -C "fxxxx@.com"`
9. Private ssh - Essa chave será usada na geração de ssh keys no github
   `cat ~/.ssh/id_rsa.pub`
10. Configure a chave do github
    `git config --global user.name "bxxx"`
    `git config --global user.email xxxxz@xxx.com`
11. Teste ssh key
    `ssh -T git@github.com`
12. Config git credentials on jenkins - Run
    `cat ~/.ssh/id_rsa`
13. Configurar o damemon do docker para expor o daemon remotamente
    `sudo mkdir -p /etc/systemd/system/docker.service.d`
    `sudo vi /etc/systemd/system/docker.service.d/override.conf`
    `past this`

[Service]
ExecStart=
ExecStart=/usr/bin/dockerd -H fd:// -H tcp://0.0.0.0:2376

`sudo systemctl daemon-reload`
`sudo systemctl restart docker.service`
`sudo systemctl status docker`

13. Get kubeconfig
    `rm -rf ~/.kube/config`

14. Get credentiasl AKS
    `az aks get-credentials --resource-group rg-lenient-kit --name rg-lenient-kitk8stest3`

15. Get kubeconfig
    `cat ~/.kube/config`
16. Configurar o damemon do docker para expor o daemon remotamente
    `sudo mkdir -p /etc/systemd/system/docker.service.d`
    `sudo vi /etc/systemd/system/docker.service.d/override.conf`
    `past this`
    [Service]
    ExecStart=
    ExecStart=/usr/bin/dockerd -H fd:// -H tcp://0.0.0.0:2376

`sudo launchctl  daemon-reload`
`sudo systemctl restart jenkins`
`sudo launchctl  restart docker.service`


17. install dashboard
18. `kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta6/aio/deploy/recommended.yaml`