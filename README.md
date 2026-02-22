6
mitä Room tekee (Entity–DAO–Database–Repository–ViewModel–UI):
Room mahdollistaa paikallisen tietokannan käytön ja pysyvän datan tallennuksen sovelluksessa;
Entity määrittelee taulun; DAO käsittelee kyselyt;
Database yhdistää ne; Repository välittää datan ViewModelille ja UI reagoi tilamuutoksiin.
  
projektini rakenne:
data/
  local/
    AppDatabase.kt
    WeatherDap.kt
  model/
    WeatherEntity.kt
    WeatherResponse.kt
  remote/
    RetrofitInstance.kt
    WeatherApi.kt
  repository/
    WeatherRepository.kt
ui/
  theme/
    Color.kt
    Theme.kt
    Type.kt
  WeatherScreen.kt
viewmodel/
  WeatherViewModel.kt
MainActivity.kt
  
miten datavirta kulkee:
Käyttäjä syöttää kaupungin UI:ssa, jonka jälkeen ViewModel kutsuu Repositorya.
Repository tarkistaa ensin Roomista datan ja hakee tarvittaessa tiedot API:sta sekä tallentaa ne tietokantaan.
Room päivittää Flow-datan, ViewModel välittää sen UI:lle ja Compose päivittää näkymän automaattisesti (Data kulkee Roomin kautta UI:lle).


(Sää) miten välimuistilogiikka toimii:
Jos nykyisen ajan ja lastUpdated-arvon välinen erotus on alle 30 minuuttia sovellus käyttää Room-tietokannassa olevaa dataa.
Mikäli data on vanhempaa kuin 30 minuuttia, sovellus hakee uudet tiedot OpenWeather API:sta ja tallentaa ne Room-tietokantaan.
