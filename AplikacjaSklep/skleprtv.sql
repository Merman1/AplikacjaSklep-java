-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 08 Kwi 2021, 14:30
-- Wersja serwera: 10.4.18-MariaDB
-- Wersja PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `skleprtv`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `agd_duze`
--

CREATE TABLE `agd_duze` (
  `id_produktu` int(30) NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `cena` int(30) NOT NULL,
  `raty` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `agd_duze`
--

INSERT INTO `agd_duze` (`id_produktu`, `nazwa`, `cena`, `raty`) VALUES
(1, 'Pralka PHILIPS', 2000, '30%');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `agd_male`
--

CREATE TABLE `agd_male` (
  `id_produktu` int(30) NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `cena` int(30) NOT NULL,
  `raty` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `komputery`
--

CREATE TABLE `komputery` (
  `id_produktu` int(30) NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `producent` varchar(30) NOT NULL,
  `cena` int(30) NOT NULL,
  `raty` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konsole,gry`
--

CREATE TABLE `konsole,gry` (
  `id_produktu` int(30) NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `producent` varchar(30) NOT NULL,
  `cena` int(30) NOT NULL,
  `raty` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konta`
--

CREATE TABLE `konta` (
  `id_konta` int(30) NOT NULL,
  `Imie` varchar(30) NOT NULL,
  `Nazwisko` varchar(30) NOT NULL,
  `Login` varchar(30) NOT NULL,
  `Haslo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `konta`
--

INSERT INTO `konta` (`id_konta`, `Imie`, `Nazwisko`, `Login`, `Haslo`) VALUES
(1, 'Jarek', 'Kot', 'Admin', 'admin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `smartfony`
--

CREATE TABLE `smartfony` (
  `id_produktu` int(30) NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `producent` varchar(30) NOT NULL,
  `cena` int(30) NOT NULL,
  `raty` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tv,audi`
--

CREATE TABLE `tv,audi` (
  `id_produktu` int(30) NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `cena` int(30) NOT NULL,
  `raty` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienia`
--

CREATE TABLE `zamowienia` (
  `id_zamowienia` int(30) NOT NULL,
  `Imie` varchar(30) NOT NULL,
  `Nazwisko` varchar(30) NOT NULL,
  `Wiek` int(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Adres` varchar(30) NOT NULL,
  `Kod_pocztowy` int(30) NOT NULL,
  `Platnosc` varchar(30) NOT NULL,
  `Data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `konta`
--
ALTER TABLE `konta`
  ADD PRIMARY KEY (`id_konta`),
  ADD UNIQUE KEY `Login` (`Login`),
  ADD UNIQUE KEY `Haslo` (`Haslo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
