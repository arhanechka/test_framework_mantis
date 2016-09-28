package tests;

import mantis.for_tests.BaseTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by roma.barabash on 9/18/2016.
 */


public class CreateOSProfileTest extends BaseTestCase {

    @Test (priority = 0)
    public void createOSProfilePositive() {
        loginPage
                .openUrl()
                .clickLoginManager();
        manageGlobalProfilesPage
                .openCreateOSProfileForm()
                .addGlobalProfile("linux","Ubuntu","13.04LTS","stable version")
                .selectCreatedOSProfile();

        Assert.assertTrue(manageGlobalProfilesPage
                .assertIfProfileIsDisplayed(),"assert If Profile Is Displayed");

        manageGlobalProfilesPage.testCleanUp();
    }

    @Test(priority = 1)
    public void createOSProfileWithOutPlatformNegative() {
        manageGlobalProfilesPage
                .openCreateOSProfileForm()
                .addGlobalProfile("","Ubuntu","13.04LTS","stable version");

        Assert.assertEquals(
                manageGlobalProfilesPage.errorGetText(),
                "A necessary field \"Platform\" was empty. Please recheck your inputs.",
                "Error on empty Platform field");
    }

    @Test(priority = 2)
    public void createOSProfileWithOutOSNegative() {
        manageGlobalProfilesPage
                .openCreateOSProfileForm()
                .addGlobalProfile("linux","","13.04LTS","stable version");

        Assert.assertEquals(
                manageGlobalProfilesPage.errorGetText(),
                "A necessary field \"Operating System\" was empty. Please recheck your inputs.",
                "Error on empty Operating System field");
    }

    @Test(priority = 3)
    public void createOSProfileWithOutOSVersionNegative() {
        manageGlobalProfilesPage
                .openCreateOSProfileForm()
                .addGlobalProfile("linux","Ubuntu","","stable version");

        Assert.assertEquals(
                manageGlobalProfilesPage.errorGetText(),
                "A necessary field \"Version\" was empty. Please recheck your inputs.",
                "Error on empty Operating System field");
    }

    @Test(priority = 4)
    public void createOSProfileWithOutDescriptionPositive() {
        manageGlobalProfilesPage
                .openCreateOSProfileForm()
                .addGlobalProfile("linux","Ubuntu","13.04LTS","")
                .selectCreatedOSProfile();

        Assert.assertTrue(manageGlobalProfilesPage
                .assertIfProfileIsDisplayed(),"assert If Profile Is Displayed");

        manageGlobalProfilesPage.testCleanUp();
    }

    @Test (priority = 5)
    public void checkCreatedProfileOnReportIssue() {
        manageGlobalProfilesPage
                .openCreateOSProfileForm()
                .addGlobalProfile("linux","Ubuntu","13.04LTS","stable version")
                .selectCreatedOSProfile();

        Assert.assertTrue(manageGlobalProfilesPage
                .assertIfProfileIsDisplayed(),"assert If Profile Is Displayed");

        manageGlobalProfilesPage
                .openReportIssueForm()
                .selectCreatedOSProfile();

        Assert.assertTrue(manageGlobalProfilesPage
                .getCreatedProfileContent().contains("linux Ubuntu 13.04LTS"), "profile content is linux Ubuntu 13.04LTS");

        manageGlobalProfilesPage
                .openCreateOSProfileForm()
                .testCleanUp();
        successfulLoginPage.clickLogOut();
    }





















}
