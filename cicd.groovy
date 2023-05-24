node('linux')
{
   
  stage (Poll) {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        userRemoteConfigs: [[url: "https://github.com/ZOSOpenTools/gpgport.git"]]])
        }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/gpgport.git'), string(name: 'PORT_DESCRIPTION', value: 'GnuPG allows you to encrypt and sign your data and communications' )]
  }
}
