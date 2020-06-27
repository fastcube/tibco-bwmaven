/**
 * (C) Copyright 2019-2020 Fastcube SAS
 * (http://www.fastcube.fr/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.fastcube.factory.tibco.bw.maven.builtin;

import java.util.List;
import java.util.Properties;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Resource;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.project.MavenProject;

/**
 * <p>
 * This goal copies the TIBCO BusinessWorks project sources to a temporary
 * folder for the 'test' scope.<br />
 * These sources will be used to run the tests (see 
 * <a href="./bw-test-mojo.html">bw:bw-test</a>).
 * </p>
 * 
 * <p>
 * A builtin goal from Maven is called by this goal with a custom configuration
 * defined in the 'components.xml' file from Plexus. This allows to use the
 * builtin goal bound to a lifecycle phase without adding configuration in POMs.
 * <br />
 * Please refer to {@link AbstractWrapperForBuiltinMojo} for a full explanation
 * of the lifecycle binding of a builtin Maven plugin.
 * </p>
 * 
 * <p>
 * <u>Original goal</u> :
 * <b>org.apache.maven.plugins:maven-resources-plugin:copy-resources</b>
 * </p>
 * 
 * @goal copy-bw-test-sources
 * @inheritByDefault true
 * @requiresProject true
 * @aggregator true
 * @requiresDependencyResolution test
 *
 * @author Radwane Mabchour
 * 
 */
public class CopyBWTestSourcesMojo extends AbstractWrapperForBuiltinMojo<Resource> {
	// Mojo configuration
	/**
	 *  @parameter property="groupId"
	 */
	protected String groupId;

	@Override
	protected String getGroupId() {
		return groupId;
	}
	
	/**
	 *  @parameter property="artifactId"
	 */
	protected String artifactId;

	@Override
	protected String getArtifactId() {
		return artifactId;
	}
	
	/**
	 *  @parameter property="version"
	 */
	protected String version;

	@Override
	protected String getVersion() {
		return version;
	}

	/**
	 *  @parameter property="goal"
	 */
	protected String goal;

	@Override
	protected String getGoal() {
		return goal;
	}

	// Environment configuration
	/**
	 * The project currently being build.
	 *
	 * @parameter property="project"
	 * @required
	 * @readonly
	 */
	protected MavenProject project;
	
	@Override
	protected MavenProject getProject() {
		return project;
	}

	/**
	 * The current Maven session.
	 *
	 * @parameter property="session"
	 * @required
	 * @readonly
	 */
	protected MavenSession session;
	
	@Override
	protected MavenSession getSession() {
		return session;
	}

	/**
	 * The Build Plugin Manager (this one is Java5 annotation style).
	 */
	@Component (role = BuildPluginManager.class)
	protected BuildPluginManager pluginManager;
	
	@Override
	protected BuildPluginManager getPluginManager() {
		return pluginManager;
	}

	// Configuration
    /**
     * The actual Mojo configuration found in the Plexus 'components.xml' file.
     * <pre>  		
     *	&lt;component>
 	 *		&lt;role>org.apache.maven.plugin.Mojo&lt;/role>
 	 *		&lt;role-hint>default-copy-bw-test-sources&lt;/role-hint>
	 *		&lt;implementation>io.github.fastcube.factory.tibco.bw.maven.builtin.CopyBWTestSourcesMojo&lt;/implementation>
	 *		&lt;isolated-realm>false&lt;/isolated-realm>
	 *		&lt;configuration>
	 *			&lt;groupId>org.apache.maven.plugins&lt;/groupId>
 	 *			&lt;artifactId>maven-resources-plugin&lt;/artifactId>
	 *			&lt;version>2.6&lt;/version>
	 *			&lt;goal>copy-resources&lt;/goal>
	 *				&lt;resources>
	 *					&lt;resource>
	 *						&lt;directory>${bw.project.location}&lt;/directory>
	 *						&lt;filtering>true&lt;/filtering>
	 *					&lt;/resource>
	 *				&lt;/resources>
	 * 				&lt;configuration>
	 * 					&lt;property>
	 * 						&lt;name>outputDirectory&lt;/name>
	 *  						&lt;value>${project.build.test.directory.src}&lt;/value>
	 * 					&lt;/property>
	 * 				&lt;/configuration>
	 *		&lt;/configuration>
 	 *		&lt;requirements>
     *			&lt;requirement>
	 *				&lt;role>org.apache.maven.plugin.BuildPluginManager&lt;/role>
     *				&lt;role-hint />
     *				&lt;field-name>pluginManager&lt;/field-name>
     *			&lt;/requirement>
     *		&lt;/requirements>
	 *	&lt;/component>
	 * </pre>
     * @parameter
     */
    protected Properties configuration;
	
    @Override
	protected Properties getConfiguration() {
		return configuration;
	}
    
    /**
    * Optional resources parameter do define includes/excludes filesets
    * 
    * @parameter
    */
    protected List<Resource> resources;
	
    @Override
	protected List<Resource> getResources() {
		return resources;
	}

}
