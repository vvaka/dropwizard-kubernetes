# dropwizard-kubernetes
Dropwizard kubernetes sample app using fabric8  openshift v3
 1) checkout fabric8-installer 
    https://github.com/fabric8io/fabric8-installer.git
    
 2) cd fabric8-installer/vagrant/openshift
 
 3) vagrant up
 
     
    export KUBERNETES_DOMAIN=vagrant.f8
    export DOCKER_HOST=tcp://vagrant.f8:2375
    oc login https://172.28.128.4:8443
    username/password :  admin/admin
   
  4) vagrant landrush  start    on Mac to make sure the DNS is running   
    
  To verify if the install is successful . 
  
    
  oc get pods
  
  
  
 cd dropwizard-kubernetes  
  
 run  $mvn clean install docker:build fabric8:recreate fabric8:delete-pods
 
 
  login to  fabric8.f8
  username/password :  admin/admin
  
  Go to Kubernetes -> Apps tab 
  
  Run the app template chat
  
  run  the app template chaos-monkey