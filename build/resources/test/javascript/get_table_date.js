
//js скрипт, получаем таблицу, данными из таблицы наполняем json объект и возвращаем его
jsonObject = {};
$(".table-responsive tbody tr").each(function(i, element) {
    key = $(element).find("td").first().text();
    value = $(element).find("td").last().text();
    jsonObject[key] = value;
});
return JSON.stringify(jsonObject);










