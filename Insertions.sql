
INSERT INTO Musician (SSN,Full_Name,Address,House_Number)
VALUES ("477-13-1811","Mick Jagger","777 cat st",3815940121);

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("477-13-1811",100,1);

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (1,"Harmonica","C","477-13-1811");

INSERT INTO Album (AlbumID,Title,Copyright_Date,Format,Playlist_Size,SSN)
VALUES (1,"Exile on Main St.","05-12-1972","CD",18,"477-13-1811");

INSERT INTO Song (AlbumID,TrackID,Title,SSN_Author)
VALUES (1,1,"Rocks Off","477-13-1811");

INSERT INTO Musician (SSN,Full_Name,Address,House_Number)
VALUES ("456-76-1811","John Frusciante","738 turtle st",7893820121);

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("456-76-1811",80,1);

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (2,"Fender Standard Guitar","G Major","456-76-1811");

INSERT INTO Album (AlbumID,Title,Copyright_Date,Format,Playlist_Size,SSN)
VALUES (2,"Stadium Arcadium","04-03-2006","CD",28,"456-76-1811");

INSERT INTO Song (AlbumID,TrackID,Title,SSN_Author)
VALUES (2,1,"Dani California","456-76-1811");

INSERT INTO Song (AlbumID,TrackID,Title,SSN_Author)
VALUES (2,2,"Snow","456-76-1811");

INSERT INTO Musician (SSN,Full_Name,Address,House_Number)
VALUES ("179-13-1241","Keith Moon","1270 whiskey st",7283645152);

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("179-13-1241",54,1);

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (3,"Tama Drums","D","179-13-1241");

INSERT INTO Album (AlbumID,Title,Copyright_Date,Format,Playlist_Size,SSN)
VALUES (3,"Who's Next","8-14-1971","CD",9,"179-13-1241");

INSERT INTO Song (AlbumID,TrackID,Title,SSN_Author)
VALUES (3,9,"Won't Get Fooled Again","179-13-1241");

INSERT INTO Musician (SSN,Full_Name,Address,House_Number)
VALUES ("079-13-1001","Roger Waters","1270 whiskey st",7283645152);

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("079-13-1001",54,1);

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (4,"Piano","E-Flat","079-13-1001");

INSERT INTO Album (AlbumID,Title,Copyright_Date,Format,Playlist_Size,SSN)
VALUES (4,"Dark Side of the Moon","3-1-1973","CD",10,"079-13-1001");

INSERT INTO Song (AlbumID,TrackID,Title,SSN_Author)
VALUES (4,6,"Speak To Me","079-13-1001");

INSERT INTO Musician (SSN,Full_Name,Address,House_Number)
VALUES ("619-92-2901","Chris Wolstenholme","1872 Black River st",9683194152);

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("619-92-2901",34,1);

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (5,"Bass","G-Flat","619-92-2901");

INSERT INTO Album (AlbumID,Title,Copyright_Date,Format,Playlist_Size,SSN)
VALUES (5,"Absolution","9-22-2003","CD",14,"619-92-2901");

INSERT INTO Song (AlbumID,TrackID,Title,SSN_Author)
VALUES (5,14,"Fury","619-92-2901");

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("063-21-2001",24,3);

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (7,"Bass","G-Flat","063-21-2001");

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (6,"Guitar","C-Flat","063-21-2001");

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (8,"Drums","Any","063-21-2001");

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (9,"Guitar","Any","619-92-2901");

INSERT INTO Instrument (InstrumentID,Full_Name,Musical_Key,SSN)
VALUES (10,"Synthesizer","Any","619-92-2901");

Select AlbumID, Copyright_Date, Format from Album 
where SSN = (Select SSN from Musician where Full_Name="John Frusciante");

Select m.SSN, m.Full_Name, m.Address, m.House_Number from Musician m, Instrument i where
m.SSN = i.SSN and i.Full_Name="Guitar" order by m.Full_Name DESC;

Select s.TrackID, s.Title from Song s, Album a where a.AlbumID = 5 and a.AlbumID = s.AlbumID;

INSERT INTO Musician (SSN,Full_Name,Address,House_Number)
VALUES ("231-22-2903","Lady Gaga","123 Riverwalk st",2288994852);

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("231-22-2903",24,0);

INSERT INTO Album (AlbumID,Title,Copyright_Date,Format,Playlist_Size,SSN)
VALUES (6,"Cheek to Cheek","1-20-2015","CD",10,"231-22-2903");

INSERT INTO Musician (SSN,Full_Name,Address,House_Number)
VALUES ("971-22-2253","Katy Perry","103 NoMusicallSkill st",7123994842);

INSERT INTO Musician_Talents (SSN,No_Of_Songs,No_Of_Instruments)
VALUES ("971-22-2253",36,0);

INSERT INTO Album (AlbumID,Title,Copyright_Date,Format,Playlist_Size,SSN)
VALUES (7,"Imaginary Album","11-30-2015","CD",12,"971-22-2253");

Select m.Full_Name, n.No_Of_Songs, from Musician m, Musician_Talents n where No_Of_Songs >=(Select AVG(No_Of_Songs) from Musician_Talents) AND m.SSN = n.SSN;

Select Count(*) as NoOfAlbums from Album where Copyright_Date between "1-20-2015" AND "11-30-2015";

Select m.Full_Name from Musician m, Musician_Talents n where n.No_Of_Instruments>=2 and m.SSN = n.SSN;

Select n.Full_Name, m.No_Of_Performances from Musician_Talents m, Musician n where m.SSN = n.SSN;