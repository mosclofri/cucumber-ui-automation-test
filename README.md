# cucumber-appium-java-test

 This repository contains sample usage of  [cucumber-ui-automation-framework](https://github.com/mosclofri/cucumber-ui-automation-framework)

## Running Your Tests

 * You can basically run your test with default settings via `mvn clean install`
 * If you like to override default run settings you can just run it with
        
        #This will run your test on iPhone 6 simulator
        mvn clean install -Dspring.profiles.active="ios" -Ddevice.name="Iphone 6" -Dapp.file="myiosapp.ipa"
        
 * By default cucumber will execute every scenario except ones with `@ignore`
  
        #This will run scenarios tagged with @accounts and @p1
        mvn clean -D"cucumber.options=--tags @accounts --tags @p1" install
        #This will run scenarios tagged with @accounts or @p1
        mvn clean -D"cucumber.options=--tags @accounts,@p1" install
        
 * Thus
 
        #This will run your account test on android device named xxxxx with default imlicit wait 10 seconds
        mvn clean -D"cucumber.options=--tags @accounts" -Ddevice.name="xxxxxx" -Dimplicit.wait="10"
        
### Reporting

  * After the test execution you can find generated HTML report in `/target/cucumber-html-reports` folder
  
### Project Structure

 * Your app package should be like com.appium.test.* to spring can be able to autowire your classes
 * Your pom.xml should look like this.
  
                <parent>
                    <groupId>com.github.mosclofri</groupId>
                    <artifactId>cucumber-ui-automation-framework</artifactId>
                    <version>0.6.2-SNAPSHOT</version>
                </parent>

                <artifactId>cucumber-appium-java-test</artifactId>
                <version>${project.parent.version}</version>

                <dependencies>
                    <dependency>
                        <groupId>com.github.mosclofri</groupId>
                        <artifactId>java-appium-framework</artifactId>
                        <version>${project.parent.version}</version>
                    </dependency>
                </dependencies>

                <build>
                    <plugins>
                        <plugin>
                            <groupId>org.apache.maven.plugins</groupId>
                            <artifactId>maven-surefire-plugin</artifactId>
                            <version>${surefire-version}</version>
                            <configuration>
                                <systemPropertyVariables>
                                    <spring.profiles.active>Android</spring.profiles.active>
                                    <platform.name>Android</platform.name>
                                    <appium.host>127.0.0.1</appium.host>
                                    <appium.port>4799</appium.port>
                                    <implicit.wait>3</implicit.wait>
                                    <app.file>api-demos-debug.apk</app.file>
                                    <device.name>emulator-5554</device.name>
                                </systemPropertyVariables>
                                <testFailureIgnore>true</testFailureIgnore>
                                <workingDirectory>${basedir}</workingDirectory>
                            </configuration>
                        </plugin>
                    </plugins>
                </build>

                <repositories>
                    <repository>
                        <snapshots>
                            <updatePolicy>always</updatePolicy>
                        </snapshots>
                        <id>cucumber-appium-java-mvn-repo</id>
                        <url>https://raw.github.com/mosclofri/cucumber-ui-automation-framework/mvn-repo/</url>
                    </repository>
                </repositories>

## Tips
### Locating Elements

 While using PageFactory and AppiumFieldDecorator define and locate elements. It will decorate your element according to platform in test.
 
    @AndroidFindBy(id = "checkbox_button")
    @iOSFindBy(id = "check_button_id_in_your_ios_app")
    public MobileElement CHECKBOX_BUTTON;
        
    #If your element is not native. You must use @FindBy to locate it.
    #But for sure you need to change context to interact with it
    #For easy change you can use 'alertDialogsPage.getHelper().switchContextToFirstWEBVIEW();'
    @FindBy(id = "web_view_id")
    public MobileElement CHECKBOX_BUTTON;
        
 While locating element with findElement
         
    MobileElement element = alertDialogsPage.getDriver().findElement(By.xpath("//xpath']"));
     
### Implicit and Explicit Waits

 An **implicit** wait is to tell Driver to poll for a certain amount of time when trying to find an element
 or elements if they are not immediately available. Once set, the implicit wait is set for the life of
 the Web Driver object instance until it changed again.
    
 An **explicit** waits is the code you define to wait for a certain condition to occur before proceeding further in the code.
 WebDriverWait in combination with ExpectedCondition is most common way this can be accomplished.
     
    If (given implicit time >= explicit time)
        explicit time is ignored and driver will wait till implicit wait value
    if (given explicit time >= implicit time)
        max time taken to find element (or condition) will vary between implicit wait value and and sum of implicit wait and explicit wait
     
 Setting high implicit wait is blindly telling Selenium, if you don't find my element, then wait for a certain time until.
 No matter what it is, no matter the consequence, no matter what happened, you wait until you either find it or wait duration has passed.
 So try to keep your implicit wait value as low as possible and use explicit wait where wait needed
    
 * **Controlling Implicit Wait**

 While using PageObject driver.manage.timeouts does not have any effect. Each element holds its' own implicit timeout and its assigned while decorating the elements 
                
 So If you need to change your implicit wait time you can do
    
    alertDialogsPage.getHelper().initElementsWithFieldDecorator(AlertDialogsPage.class, 10);
    
 You can set it back to default value any time with below code
 
    alertDialogsPage.getHelper().initElementsWithFieldDecorator(AlertDialogsPage.class);
    
 If you want override implicit wait time for elements that located with findElement() you can do
    
    alertDialogsPage.getHelper().setDriverWaitTime(10);
    
 * **Controlling Explicit Wait**
 
 Explicit wait is same for elements for both findElement() and PageObject
 
    new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(By.xpath("//xpath")));
    
 * **Override Both Implicit and Explicit Wait**
 
 Annotation @WithTimeout will override every wait and wait that element until exact that value
 
    @AndroidFindBy(id = "checkbox_button")
    @iOSFindBy(id = "check_button_id_in_your_ios_app")
    @WithTimeout(time = 1, unit = TimeUnit.SECONDS)
    public MobileElement CHECKBOX_BUTTON;