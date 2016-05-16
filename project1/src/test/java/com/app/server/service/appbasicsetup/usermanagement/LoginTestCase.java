package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private Login createLogin(Boolean isSave) throws Exception {
        User user = new User();
        user.setIsDeleted(1);
        user.setSessionTimeout(2182);
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(15885);
        user.setChangePasswordNextLogin(1);
        user.setPasswordAlgo("hL1QFmhIIikMJUIUSSd3Om9W5QpJTZsd5VOp430YGrbAbJlSlb");
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainName("bgPY5roKmldEn1J7SVjHZQxbFG1yls5zvlxnuf4JgE2gAqQX0q");
        useraccessdomain.setDomainDescription("YW6fQkUxsijuaLAfZjFuPVZXJbLfu9Csf0NMy4Tmai6mQ0jmvO");
        useraccessdomain.setDomainIcon("FzFF5C4t30hfFtRFxi7IotPHqDMhFWMIrPtykTupXsunjKVNlS");
        useraccessdomain.setDomainHelp("g2e9CN8PZ7gnMFYkRVBM8Dc7r2b9jizG0zdcbKtLzKlP8mx6Gh");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("Y929OiYJgTByYTAFS6WYc59NRK9Nludthe2dcaeDfqlhb8WN3G");
        useraccesslevel.setLevelDescription("4Fd3HvkCi1PZa6IhBXl1uRdoSCbF3JWjp7pDMrfXRiBDTrZdW3");
        useraccesslevel.setLevelIcon("it1fsueVPS4aE3T0ordBg78K6XWkNG95HXuJVdzRvojBHYxrOx");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("Fc036MfbhZaCb890daIr86q0nLhov5jktmWJ3yOeKNkAHEoWSP");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setIsDeleted(1);
        user.setSessionTimeout(1696);
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(42198);
        user.setChangePasswordNextLogin(1);
        user.setPasswordAlgo("QFafMWvGUoZxkDBxrOKgMAg2S39CKmf8HGANhxnl6ZEZr9Zjvh");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463382494711l));
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setIsLocked(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463382494741l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("DM5jqgSW6GbgWb9ohbd7M9V0Nd8KoueJBPiyzLHACV0Z5hMjlo");
        Question question = new Question();
        question.setQuestionDetails("ohnzPEfYwm");
        question.setLevelid(7);
        question.setQuestionIcon("4ors9DFXUCNU9XFvWp13D6niGdpP4xi99Tl3x7QLrPa0dDlnh7");
        question.setQuestion("PLbgUmikRNlmyAHRfCBHS8aKPTzsW9pdkLHy42Qnx2ivsEVnVC");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("DqtSCMF5Mm1Pe2i0SQXDzCXNejOaQ8J5RPD7VUQ4TFKVbnTtHo");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("U7NoP4cLZA2FJhoXLUys5Z8AWcBqOlWopDFfpEfcik2HBkgSpC");
        userdata.setOneTimePasswordExpiry(6);
        userdata.setOneTimePassword("aK7TZlZnpV7LyA2fZWPvBFYhAJcRIQAQ");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463382494918l));
        userdata.setPassword("xPUxo6NAQrwkH2z6quZgwKnxf8T3s7Fm2A1UKeKdhWi6RbCJ6T");
        userdata.setOneTimePasswordExpiry(1);
        userdata.setOneTimePassword("M2wj4MLSkDmiNy2TIA717aims0aWxin3");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463382494937l));
        userdata.setUser(user);
        userdata.setLast5Passwords("uULKpYlGGmgy2VEfRPYN0xKW6Ntdxw7Cylz5uLUFqTLpN1xpwG");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeFirstName("FEqZbVI5g7NycsB7OYEn7kqNMNKOVkkt7jjEQ7mV2sr0fIxJur");
        Title title = new Title();
        title.setTitles("7VajHLpNPFcxoiy2Kdid5tLNTTT5Ivg4dOZeNM24A6nXYR0DwK");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("8AShCDgcnerANFfQYDkNgPWZDSj5AEBsIVdG3sGw0XFOhrTRMz");
        timezone.setCities("rKdDY99ocpEhhtNqu1ouWTzXrdRO3ur0kHPjqah3RvQ5081p01");
        timezone.setTimeZoneLabel("hwlsdyNKOIJWPC5yGg3C3VaW7JJRaDWF2p9xkQBoskSVrWMd14");
        timezone.setUtcdifference(7);
        timezone.setGmtLabel("fLRkI3AN675Ytq0S12YmUFscCNv9CCXu8o9l2NQxcf2FzQOeH9");
        Language language = new Language();
        language.setLanguageDescription("b2CSOyCZFQfFuWcH3P4yYI77nt6yBNb07xLYbkeO9Tv6jfV9o5");
        language.setLanguageIcon("Kyhtcfd45C4VLRNgcmwK80rkjuoOzKKZuSm67vvLIJzjPZK3n5");
        language.setAlpha3("eOZ");
        language.setLanguage("kUMAsMV2UIbaCNS9AvPuOI7sUnwGVmnd5WTpjPuiXMC3vkfni8");
        language.setAlpha4("bpeZ");
        language.setLanguageType("PduR4uuX33mpwMyRPJpoHy8gtSmcweFc");
        language.setAlpha4parentid(9);
        language.setAlpha2("pd");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("DRuHYs3LTsxeBrd9jPNSl5xqqJANMpnR6QQqRxC29RHDGedyDz");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setNativeFirstName("xKfCPNF5blXy91M68W7KRu9CfW9UfPUCK3Z8If9i0pBzr8tKEH");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463382495077l));
        corecontacts.setNativeLastName("fIeqnzwqfb144ytoyluHqkr0a9BMrLJPJyf2vetju0x3pF0HNU");
        corecontacts.setNativeMiddleName("OB0qMqaV7qgoRAGvg31R70yP6sqIHUQM02OZP0jBGv2Z5Kc0rX");
        corecontacts.setLastName("A8mnFmM7mb1aUPZku4MxMVuhDjdUYC6ETvglu5S528a8x7YlvZ");
        corecontacts.setPhoneNumber("yVNSASmExn05DGX9yTBj");
        corecontacts.setAge(69);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setEmailId("C2w2jVVyh9oGqVK9w0WYrMrzfenb5hUvW3E76andjN605IxyEc");
        corecontacts.setMiddleName("38gIX9BL6ggqYLGH98uiI5JGBrF8aQbrhu492y02fP5LSxX96I");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463382495137l));
        corecontacts.setFirstName("zw9K8vjlGzhcjfAWZStjvJ0OG793hqj9d7biOqjrPlpr8b7gyz");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("54pJ4ptjra09cKZgbNT2LEqRrvN7wb80WKNjJMKi5Oq8RbfLaX");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddressLabel("OsLxxS6FeCv");
        address.setAddress3("rLPdqxaPMvOiTMFyfNs7K2fwjZjdgYAQaTSNDYxpmXUYIZzKvr");
        State state = new State();
        Country country = new Country();
        country.setCapitalLatitude(1);
        country.setCountryCode2("dsQ");
        country.setIsoNumeric(714);
        country.setCountryFlag("ff5Jo3hegQllKD4lhNlOVpGsTXH9uPPYUEfZvSNMIMkxUUZFsq");
        country.setCurrencyCode("22o");
        country.setCurrencySymbol("lM93Q9Se02EGUHcaH35QihoUah1BOH57");
        country.setCountryCode1("ztY");
        country.setCurrencyName("C74I7ymHJfxyckYciUteqTW8LlPlx4WYy3yBCzIr0pA4rrcdEO");
        country.setCapital("ENNUdxK1YfoEOxHdGNTjLbomuEoGyBeZ");
        country.setCountryName("LPyIXR8aCENWbAidSi3VBZSPNU8da498Xw0xs1XZg6QLI3d6w8");
        country.setCapitalLongitude(11);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("T3g0Z5EwbnX7dTxKULj1mjAh1ZdLSurn");
        state.setStateCapital("agLTXwfKEUS5Q8PHEsLAh26ZPnJgLZfZfnC35cyeHryZaf11XM");
        state.setStateName("O2iWqwpFp7saAnH6PxfdiEgNHijpVCuXvS3iu4J1aEBRBldSmw");
        state.setStateFlag("lKpAokOV0xUoUIti4xOlQfRoAhSiLz8T8YzWwEeDEh8kEk1rYd");
        state.setStateDescription("0rnFID4vVu6vOOllwSKk3QTbDmyDiwSAJetp30D3VXTufSmnFy");
        state.setStateCapitalLongitude(2);
        state.setStateCodeChar2("HXMxSS8XJj04CtcTFKVW1nA8WszVIDnQ");
        state.setStateCapitalLatitude(11);
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("MdcY6NbO9idcrsu14lreEBgluV5MtKtymp0cjU6JAoE3iLQuWx");
        addresstype.setAddressTypeDesc("2XK6clb3kJCkDJESOFkNID8LM2JDdFwiTWKSy9tmKPHXspRc2k");
        addresstype.setAddressType("eQntnm4GdNOw3Auoih2VL8aIjttvFS1PzWHvqT7MDnoKAqgqcB");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("NG4hQ0BZFCCCJQXCKdt1p25lhB9xXGI1qCrnW7M3WjdgUMfXKp");
        city.setCityCode(3);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("5eqCqhYcuggOl69N8yqGzdvwUDKw9C1QeEBtX9SKUSK1T4eFnT");
        city.setCityLongitude(7);
        city.setCityLatitude(7);
        city.setCityCodeChar2("MV5lDDUOnBpZFWiUn3siVg8u25bTj9Lx");
        city.setCityName("RngYTt2EBTZOjW9eMCW3e8WtuUXteAdv5mXBObVbMfNXP1jLdc");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressLabel("7aQzOq6Nb2S");
        address.setAddress3("Hpnf7GTRsMH5aMBrbgONbG6Xz9cqANPxCDnVkw6kwTNbqZsEWq");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("Ur0A7znhYSjYwRz0nLX1RdTNEj6uopEUOZEak4RC3aUSEWegHR");
        address.setZipcode("zLokBy");
        address.setAddress1("gkDxmHRW5hBPTmtuBwHgmLUIX9hdJS5swvG8yst8W3d6ogcNIt");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("P6jlHC5lV2tsZiBUj2nrNW3O7Ola8juTn4SvJLhZcVPcUigeii");
        address.setAddress2("eFRHMgUTFLGn7rhvg1nVPKkTUPxs3wY3CMOZF7VrNgFUWglhH0");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("Ogg6s85V6YFXdrUh6ZK7IuyldFGpu7eKr9LQEXBm8p83Jb9862");
        communicationtype.setCommTypeDescription("ZnLfEkw7l5KHpapuYC2kWbqnZI77SOPHHw2SgNXZWxzQnO4Ssw");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("miWET5RFRYdFJOCDJWDMt6RIoVEeJ61bUjJko2e2EOlW0tpELz");
        communicationgroup.setCommGroupDescription("hDY2lhWdqISnRYa9jOTAI3lMDe9375OOl7IVFRNWylU4OjcRub");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("vCDNtXkn3mp23s0WpW71Ge2icwtE3p9jjNpq983zIARWxhoPTN");
        communicationtype.setCommTypeDescription("TqtsKHTPBJuaNiUeV14FiEwtJuehRVscfx3jzwGr2WOB8JUJ8e");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("6maXeCG2B0");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        login.setServerAuthImage("tPk9fvcJs8YD37jzMvLgWM55kGsVCfUv");
        user.setUserId(null);
        login.setUser(user);
        login.setIsAuthenticated(true);
        login.setFailedLoginAttempts(10);
        login.setLoginId("PFDoHT1IcuPkDG34GGyUSHsI7nH54DZNzbvPI6CjNHqyc9WiLt");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthText("z4zGlFOokxCJMI3d");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthImage("t0ZEuH3awRullyasyBpXu7nfPMkXQmJk");
            login.setVersionId(1);
            login.setFailedLoginAttempts(6);
            login.setLoginId("jqoFQkhD3D1P9uA7iqjQ0Gg7SjfX6d6fIg4SO5QdilbUTzVFCz");
            login.setServerAuthText("5okwoi0CMBRtsojJ");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "SJVdSCRcjPTvrRnmFAtf2iuBcgFK2fuZI3oWQ3zXkAuJf8caC1Bv3UkbveKf4O1207KkgmbEhT0BAUGEXAsibqnDyOo4QM7zvISAUe4eQpl1cG31bCB9IxxjWGHNhBnIAsayr2Z6yZm0jBojhgIr5qpPdBhipm32E0d8DGMAy4pfhfYYh5BbwN3GAhFHlxbUmzVLoyCUI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "bhwQRWlo0GjLKDXcn5ojvl2E4cw1ggBPE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "9NP9VSJ4Xa3NC6PDp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
