select p.numero, p.nimi, p.hinta from pizza p;

select p.id, p.numero, p.nimi, p.hinta, p.energia, p.proteiini, p.hiilihydraatti, p.rasva from pizza p;

select t.nimi from tayte t, pizzantayte pt where t.id = pt.tayte_id and pt.pizza_id = 1;





select p.numero, p.nimi, p.hinta, group_concat(t.nimi SEPARATOR ', ') as taytteet from pizza p, tayte t, pizzantayte pt where t.id = pt.tayte_id and pt.pizza_id = p.id GROUP BY p.id;


select p.numero, group_concat(t.nimi SEPARATOR ', ') as taytteet from pizza p, tayte t, pizzantayte pt where t.id = pt.tayte_id and pt.pizza_id = p.id GROUP BY p.id;


juoman haku:

select j.id, j.numero, j.nimi, j.maara, j.hinta, j.energia, j.proteiini, j.hiilihydraatti, j.rasva from juoma j;