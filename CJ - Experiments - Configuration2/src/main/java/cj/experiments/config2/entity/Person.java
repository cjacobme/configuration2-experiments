package cj.experiments.config2.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Person
		implements
		Serializable
{
	static final long serialVersionUID = 1L;

	private String name;

	private LocalDate birthday;

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDate getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(LocalDate birthday)
	{
		this.birthday = birthday;
	}

}
