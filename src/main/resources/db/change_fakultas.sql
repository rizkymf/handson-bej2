create or replace procedure change_fakulas(kode_fakultas_from character varying, kode_fakultas_to character varying)
language plpgsql
as $$
declare
	-- deklarasi variabel
	kode_fakultas_changed character varying := kode_fakultas_from;
	kode_jurusan_1 record;
begin
	-- update kode fakultas dari 04 -> 02
	update jurusan set kode_fakultas = kode_fakultas_to
		where kode_fakultas = kode_fakultas_from;

	-- loop di sql
	-- update nama jurusan dari (nama) -> Seni + (nama)
	for kode_jurusan_1 in select kode_jurusan from jurusan
		where kode_fakultas = kode_fakultas_to
	loop
		update jurusan set nama = 'Seni ' || nama
			where kode_jurusan = kode_jurusan_1::character varying;
	end loop;

	-- if statement di sql
	if kode_fakultas_changed = '02'
	then
	-- di java ini System.out.println
		raise notice 'fakultas has changed to Seni!';
	end if;

	--commit;
end; $$