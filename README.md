## Jenkins
### Introduction
Jenkins provision using Docker, Docker-Compose with Jenkins configuration-as-code plugin.

### Configure
#### Configuration as Code
`casc_configs` contains a set of config files.
* `jenkins.yml` base configuration

#### Plugins
[plugins.txt](plugins.txt) contains sorted [name]:[version] list of plugins to install.

### Pipeline Library
[src](src) contains pipeline-library implementation example.

### Provision
```
docker-compose up -d
```
