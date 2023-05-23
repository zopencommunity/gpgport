node('linux')
{
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/gpgport.git'), string(name: 'PORT_DESCRIPTION', value: 'GnuPG allows you to encrypt and sign your data and communications' )]
  }
}
