insert into clients(id, first_name, last_name, phone_number, national_Id) values
  (1, 'Jan', 'Kowalski', '789-543-123','91082741457'),
  (2, 'Maciej', 'Zalewski','564-231-412', '89051069877'),
  (3, 'Aneta', 'Korczyńska','698-314-455', '88120962341'),
  (4, 'Wojciech', 'Sokolik','777-422-444', '80050146538');

insert into mechanics(id, first_name, last_name, phone_number,salary) values
  (1, 'Tomasz', 'Kamiński', '888-034-860',4000),
  (2, 'Hieronim', 'Walczak','781-578-787', 6000),
  (3, 'Ksawery', 'Kowalski','728-397-530', 3500),
  (4, 'Grzegorz', 'Rutkowski','517-830-326', 3500),
  (5, 'Radosław', 'Woźniak','665-795-949', 3500),
  (6, 'Ireneusz', 'Kaczmarek','531-176-511', 4000),
  (7, 'Maksymilian', 'Nowicki','674-216-463', 3000),
  (8, 'Grzegorz', 'Duda','667-019-747', 3000);

insert into cars(id,vin,brand,model,registration_number) values
    (1,'WVG2HY9G485FN0546','Volkswagen','Golf','KR883XZ'),
    (2,'WV1Z0UFXU6ZZH5730','Volkswagen','Tiguan','KR676QZ'),
    (3,'WV1XCA4JTHKES3300','Volkswagen','Golf','KR00011'),
    (4,'VWVMF25R813HF1579','Volkswagen','Polo','KRA982EW'),
    (5,'VWVA5UA0152DZ7021','Volkswagen','Passat','KRDF892'),
    (6,'WVGBPMP8NRE125501','Volkswagen','Golf','KR7979A'),
    (7,'WAU7EWY5CD0AY2469','Audi','A4','KR6509R'),
    (8,'WA1HDW4DJM4GE7658','Audi','A4','KT6534T'),
    (9,'WA1HNS8N4LVPD8094','Audi','A5','KR351TD'),
    (10,'WAU3VHUB6XGRM6904','Audi','A6','KR4K1KS'),
    (11,'WAUUMLTAS5L1Z1134','Audi','A6','KR9W09W'),
    (12,'WAUX46A2MBPYM5849','Audi','A7','KR1312X'),
    (13,'WA1T9661L6N109996','Audi','A1','KR9ACAB'),
    (14,'WA1HJM08TNUA31202','Audi','A1','KR6509R'),
    (15,'WBAV1LNR8HMB91216','BMW','X3','KR8753S'),
    (16,'WBSMBV93G4KDM4763','BMW','X3','KR2S2S2'),
    (17,'WBSECXVGHPLUA5527','BMW','X5','KR90029'),
    (18,'WBW4LN2N76W4A8426','BMW','X5','WI8L9FS'),
    (19,'WBS8UB9WCMGDW8937','BMW','X6','KR9XC9X'),
    (20,'WBSNGD7VN6L3U6755','BMW','M440i','KR98X89'),
    (21,'WBSAY240MZW134086','BMW','330i','WI90I9S'),
    (22,'WBW85GZZDZLK02761','BMW','M5','KR87F3S'),
    (23,'WBSFJV8G1HZCU9261','BMW','X4','KR83S51');

insert into category(id,name,description) values
    (1,'Servicing','Full, major and interim services to secure your car'),
    (2, 'Diagnostic','The warning light on your car dashboard is just the beginning'),
    (3,'Heating & AC','If you notice that the air conditioning in your car isn’t providing the usual levels of cold air, it’s probably time for a regas'),
    (4,'Battery replacement', 'If your car doesn’t start when you turn the ignition switch, especially when the engine doesn’t make any attempt to turn over, your battery could be flat'),
    (5,'MOT', 'The MOT test is how the government checks your vehicle meets national safety and environmental standards'),
    (6,'Suspension & Steering', 'Shock absorber replacement - pair');