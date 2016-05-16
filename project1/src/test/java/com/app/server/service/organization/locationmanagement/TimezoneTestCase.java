package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Timezone;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TimezoneTestCase extends EntityTestCriteria {

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

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

    private Timezone createTimezone(Boolean isSave) throws Exception {
        Timezone timezone = new Timezone();
        timezone.setCountry("qmi5vd2mqpBkn9lGJftKfdEzkTalYZbF76lLiatPQIa7LxP9Bq");
        timezone.setCities("DEHqnxYW7ZCkbzwfcRR0MflexxhmKSygZ6gbEMhoAIIjKLMe8R");
        timezone.setTimeZoneLabel("0R0yq9oyvO94169S6Pst8yFd56HFJuM8SZ4YrSH7I5mXNg9Som");
        timezone.setUtcdifference(11);
        timezone.setGmtLabel("3nkPaShlNC8GvHxiZuEhAzcJkhETChOEUE1LwPACdRB5li928v");
        timezone.setEntityValidator(entityValidator);
        return timezone;
    }

    @Test
    public void test1Save() {
        try {
            Timezone timezone = createTimezone(true);
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            timezone.isValid();
            timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setVersionId(1);
            timezone.setCountry("JHnCt8KrzF6xSPWDwmKHUhIezMVzcwj1jkLO2wtQnbac0Kg4kB");
            timezone.setCities("GtoKuM4uJnk47m2a0VL4usKIPT3ljQ5bdbjUyfw799wLtcSmMG");
            timezone.setTimeZoneLabel("ID67XXwDxdcicrTPuNBOfgYJjuw3YbzKeN9QvRV4ItbCq1LWj8");
            timezone.setUtcdifference(4);
            timezone.setGmtLabel("Usyz6Hfdvz9CvNp50UnLPAFr3eN0FsxveTcboH499NCuTt7HEB");
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            timezoneRepository.update(timezone);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTimezone(EntityTestCriteria contraints, Timezone timezone) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            timezone.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            timezoneRepository.save(timezone);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "utcdifference", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "jaoGEYvRKIQijLhjUCjaGx0Fo31BlqAaRjHwWNg6M75Ol6uBsdab55DuRxxYpGFKYf7NvQdghU4CLzUkKdy0SDnPoplE9CrdwuOTTf8LodzDy7uw5N3FPt9SYO7928hPthjO0Q0lAetOZI3ojtuOVVSS7jOby4I5pihvupslT68hVinzSJ5g2FQwZ2gh74New4KjwXbsC8dIxvVDmls8EtI8nyjklw74KDoqjPisMTQqG58sbLtQsM94HXDOfyIKz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "6Uerb1dq2hxpSpVvgQtzLUdhMiZFQlhNB9SKOBfs3OgKsRrqTozGoICh9OcjK4RulHWabFohCSFB7iiyfvc246TeD9gIyn4k65FDcUA4CIQ3jtDfjP3CDWWjfWaemKjpr3Zq41kZB8oSnHv7Q8kxuF6dcxxBtjJHLUovDYMPjkJjSHiUaciCfwQyf6oWfZkS7czlhSXpbiMk6KyCeCneDl4BdIL5faqsSUqARIGNFu2HQDkc8YPye9Dx5xAe5JQ1v"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "ZucP77qiT772NTThoAHem8N2NsgWZxE1JY3oABZlxTO6cHR94Qw9szT1Kwfg6e6002rM8tg94WIVj6PLY4YZu0d881D2rfxTlKtN3PCueVbtVH1mvPH4PoBcNQCZMGMSAGMXgH0ArHdNmzkzfkPWLw3vLCfNvi9AWJwAM2VoCu5DrIdv9X5jU2YMpNiUwGR6qcnJcpNlJYEljfxvyDfxQt3bxbFQrvxythZCB2foa7CrvR2iLAosW60d37b5HBQzU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "WYSVFWStSHJCoj12mG9RhsyjC8JygTrv3fF1dozmOdbdRLBsqpmrMHR9eXidnKCxDeJi7Kr0pm4dkuUbBPYYmsQ03IHrx3jYfCVVuL9P3fyOxrJWNaNZE0QQ0vDh8ppMT19vUT2F7QKNiV4CqFG4caCrvwaS6Zl5l7oZVd1mKhOzLX819dJ8dlBD41BCaSQDWvvpmoa6kjwRqFH8Oaf2EFaG0nxQN7hzBTicygkpv0TqQ7Kcw4NiZ2chMkCDLgJdI"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Timezone timezone = createTimezone(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = timezone.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(timezone, null);
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 2:
                        timezone.setUtcdifference(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 3:
                        timezone.setGmtLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 4:
                        timezone.setTimeZoneLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 5:
                        timezone.setCountry(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 6:
                        timezone.setCities(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
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
