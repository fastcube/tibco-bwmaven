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
package io.github.fastcube.factory.tibco.bw.maven.source;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * <p>
 * This goal removes some mavenized projects as modules of a root POM.
 * <br />
 * Refer to <a href="./list-maven-projects-mojo.html">bw:list-maven-projects</a>
 * goal for an explanation about projects lists.
 * </p>
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author Radwane Mabchour
 *
 */
@Mojo ( name = "remove-maven-projects", requiresProject = false )
public class RemoveProjectsAsModules extends MavenProjectsListWithRootPOMMojo {
	
	@Override
	protected String getActionFailure() { return " project failed to be removed from the root POM."; }
	@Override
	protected String getActionFailures() { return " projects failed to be removed from the root POM."; }
	@Override
	protected String getActionSuccess() { return " project was successfully removed from the root POM."; }
	@Override
	protected String getActionSuccesses() { return " projects were successfully removed from the root POM."; }
	
	@Override
	protected boolean performAction(AbstractProject p) {
		getLog().info(p.getOriginalAbsolutePath());
		getLog().info(rootPOM.getAbsolutePath());
		File tmp = new File(p.getOriginalAbsolutePath() + File.separator + MANDATORY_MAVEN_FILENAME);
		// FIXME: exclude self
		if (rootPOM.getAbsolutePath().equals(tmp.getAbsolutePath())) {
			return false;
		}
		String relative = getRelativePath(p.getOriginalAbsolutePath(), rootPOM.getAbsolutePath(), File.separator);
		
		try {
			if (POMManager.moduleExists(rootPOM, relative, profileId, getLog())) {
				getLog().info("Removing module '" + relative + "' to '" + rootPOM.getAbsolutePath() + "'");
				POMManager.removeProjectAsModule(rootPOM, relative, profileId, getLog());
				return true;
			} else {
				String forProfile = "";
				if (profileId != null) {
					forProfile = " in profile '" + profileId + "'";
				}
				getLog().info("Skipping : '" + relative + "' is not a module of '" + rootPOM + "'" + forProfile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		super.execute();
	}

}
