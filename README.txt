This repository has sample learning projects for pivotal clound foundry.
Following is the list of quick guidelines to solve problems faced at runtime :

1. cf login not working.
	- Cross check API end point. If needed provide pivotal clound foundry api end point details in the command as below :

	 cf login -a api.run.pivotal.io


2. Rest url not accessible
	- Check if @RestController annotation declared on java class
	- Use @ComponentScan or basePackages attribute in @SpringbootApplication annotation

3 . Rest url not accessible after performing step#2
	- Perform maven clean up
	- Stop and Remove the existing app from cf using following commands :
		cf stop app_name
		cf delete app_name
	- Update the app version in POM file to make sure, new artifactory is getting genrated while using "maven install" command
	- Push the application again using "cf push" command with new version in pom.xml file


4. "mvn install" command throws DB connection error on local. 
	- Add plugins to ignore test case execution
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-surefire-plugin</artifactId>
			<configuration>
				<skipTests>true</skipTests>
			</configuration>
		</plugin>


4. "mvn install" command not working. Getting following error :
	Failed to execute goal org.apache.maven.plugins:maven-deploy-plugin:2.8.2:deploy (default-deploy) on project spring-postgres: Deployment failed: repository element was not specified in the POM inside distributionManagement element or in -DaltDeploymentRepository=id::layout::url parameter -> [Help 1]

		- Seems problem with maven repository. Clean up maven cache or delete all content of maven repository.
		- try again "mvn install" command after maven repository clean up. 