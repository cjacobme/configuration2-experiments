package cj.experiments.config2.reader;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.beanutils.BeanDeclaration;
import org.apache.commons.configuration2.beanutils.BeanHelper;
import org.apache.commons.configuration2.beanutils.XMLBeanDeclaration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.builder.fluent.XMLBuilderParameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import cj.experiments.config2.entity.Person;

public class XmlReaderTest
{
	@Test
	public void readSinglePerson() throws ConfigurationException
	{
		Parameters params = new Parameters();
		XMLBuilderParameters xmlParams = params.xml().setFileName("PersonWithBirthday.xml");
		FileBasedConfigurationBuilder<XMLConfiguration> builder = new FileBasedConfigurationBuilder<XMLConfiguration>(
				XMLConfiguration.class).configure(xmlParams);
		XMLConfiguration xmlConfiguration = builder.getConfiguration();
		BeanDeclaration decl = new XMLBeanDeclaration(xmlConfiguration, "root.grankin");
		Person person = (Person) BeanHelper.INSTANCE.createBean(decl);
		assertThat(person).as("read person").isNotNull();
		SoftAssertions softy = new SoftAssertions();
		softy.assertThat(person.getName()).as("name").isEqualTo("GRANKIN");
		softy.assertThat(person.getBirthday()).as("birthday").isEqualTo(LocalDate.now());
		softy.assertAll();
	}
}
