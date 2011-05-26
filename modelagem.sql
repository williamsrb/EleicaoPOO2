Partido:
	id(pk)									[int/serial]
	sigla									[varchar(255)]
	nome do partido							[varchar(255)]
	número									[int]

Candidato:
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

Cargo:
	id(pk)									[int/serial]	NOT NULL
	digitos									[int]	NOT NULL
	nome cargo								[varchar(255)]	NOT NULL

Votos:
	id(pk)									[int/serial]	NOT NULL
	presidente(fk - Candidato)				[int]	NOT NULL
	governador(fk - Candidato)				[int]	NOT NULL
	deputado(fk - Candidato)				[int]	NOT NULL

Urna:
	habilitada								[byte]	NOT NULL
	senha									[varchar(255)]	NOT NULL
	
