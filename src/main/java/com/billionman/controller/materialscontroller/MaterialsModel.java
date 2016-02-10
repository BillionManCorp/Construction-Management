/**
 * 
 */
package com.billionman.controller.materialscontroller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.billionman.model.Project;

/**
 * @author CTM
 *
 */
@ManagedBean(name = "materialsModel")
@SessionScoped
public class MaterialsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7363869263377889152L;

	private int selectedProject;
	private List<Project> projectList;
	private String selectedMaterial;
	private String appendPage;
	private String appendDialogPage;
	private boolean material;
	private int editingIndex;

	/**
	 * 
	 */
	public MaterialsModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the selectedProject
	 */
	public int getSelectedProject() {
		return selectedProject;
	}

	/**
	 * @param selectedProject
	 *            the selectedProject to set
	 */
	public void setSelectedProject(int selectedProject) {
		this.selectedProject = selectedProject;
	}

	/**
	 * @return the projectList
	 */
	public List<Project> getProjectList() {
		return projectList;
	}

	/**
	 * @param projectList
	 *            the projectList to set
	 */
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	/**
	 * @return the selectedMaterial
	 */
	public String getSelectedMaterial() {
		return selectedMaterial;
	}

	/**
	 * @param selectedMaterial
	 *            the selectedMaterial to set
	 */
	public void setSelectedMaterial(String selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}

	/**
	 * @return the appendPage
	 */
	public String getAppendPage() {
		return appendPage;
	}

	/**
	 * @param appendPage
	 *            the appendPage to set
	 */
	public void setAppendPage(String appendPage) {
		this.appendPage = appendPage;
	}

	/**
	 * @return the material
	 */
	public boolean isMaterial() {
		return material;
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMaterial(boolean material) {
		this.material = material;
	}

	public void clearMaterialsList() {

	}

	/**
	 * @return the appendDialogPage
	 */
	public String getAppendDialogPage() {
		return appendDialogPage;
	}

	/**
	 * @param appendDialogPage
	 *            the appendDialogPage to set
	 */
	public void setAppendDialogPage(String appendDialogPage) {
		this.appendDialogPage = appendDialogPage;
	}

	/**
	 * @return the editingIndex
	 */
	public int getEditingIndex() {
		return editingIndex;
	}

	/**
	 * @param editingIndex
	 *            the editingIndex to set
	 */
	public void setEditingIndex(int editingIndex) {
		this.editingIndex = editingIndex;
	}

}
