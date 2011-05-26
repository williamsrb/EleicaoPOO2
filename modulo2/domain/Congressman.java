package modulo2.domain;

import java.sql.Date;

public class Congressman {
	private int id;
	private int number;
	private String name;
	private int partido;
	private int cargo;
	private Date nascimento;
	/**
	id(pk)									[int/serial]	NOT NULL
	numero(suffix)							[int]	NOT NULL
	nome									[varchar(255)]	NOT NULL
	partido(fk - Partido)					[int]	NOT NULL
	cargo pretendido(fk - Cargo)			[int]	NOT NULL
	data de nascimento						[date]	NOT NULL
	sexo									[char(1)]	NOT NULL
	foto(path)								[varchar(255)]	NOT NULL
	[opcional]site							[varchar(255)]	NULL
	[deputado]apelido						[varchar(255)]	NULL
	[presidente/governador]nome vice		[varchar(255)]	NULL
	[presidente/governador]foto vice(path)	[varchar(255)]	NULL
	*/
	public static Congressman getNull() {
		return null;
	}
}
