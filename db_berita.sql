-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2018 at 05:35 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_berita`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id_history` int(11) NOT NULL,
  `id_isi` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id_history`, `id_isi`, `id_user`, `tanggal`) VALUES
(1, 1, 1, '2018-01-25');

-- --------------------------------------------------------

--
-- Table structure for table `isi`
--

CREATE TABLE `isi` (
  `id_isi` int(11) NOT NULL,
  `id_reporter` int(11) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `gambar` varchar(255) NOT NULL,
  `isi` text NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isi`
--

INSERT INTO `isi` (`id_isi`, `id_reporter`, `id_kategori`, `judul`, `gambar`, `isi`, `tanggal`) VALUES
(1, 1, 1, 'Kalahkan Halep, Wozniacki Juara Australia Terbuka', 'https://www.kent.ac.uk/sportsciences/images/swimmer2-3x2.jpg', 'Melbourne - Final Australia Terbuka 2018 menampilkan duel seru antara dua unggulan teratas, Simona Halep kontra Caroline Wozniacki. Pemenangnya adalah Wozniacki.\r\n\r\nPada duel yang dihelat di Rod Laver Arena, Sabtu (27/1/2018) sore WIB, Wozniacki yang jadi unggulan kedua harus melewati pertarungan ketat tiga set selama 2 jam 49 menit sebelum menang 7-6(2), 3-6, dan 6-4 atas Halep sebagai unggulan nomor satu.\r\n\r\nDi set pertama, Wozniacki langsung tancap gas dengan unggul 3-0 sebelum diperkecil Halep dengan 1-3. Wozniacki bahkan hanya butuh satu poin di gim ketujuh untuk menuntaskan set pertama di posisi 5-3.', '2018-01-27'),
(2, 1, 3, 'Boy Group Leader Known For His Powerful Dancing', 'https://www.allkpop.com/upload/2016/03/af_org/shownu_1458693084_af_org.jpg', 'Yoo Young Seok said, “The vocal colors of the two singers are different, but they’re both really good at singing and it was fun to listen to.” He added, “[‘Okey Donkey’] has a voice overflowing with strength. I think he hid his energy while singing. It was a voice that proves he has muscles.”\r\n\r\nShin Bong Sun guessed that ‘Okey Donkey’ must be good at dancing based on his gestures and the contestant showed off his powerful dance moves.', '2018-01-27'),
(3, 2, 1, 'Menangi Perang \"Saudara\", Tontowi/Liliyana Melangk', 'http://system.bwf.website/uploads/2016/04/17/Bonny%20China%20Masters%202015%20-%20MD%20%281%29.jpg', 'Pasangan ganda campuran terbaik Indonesia, Tontowi Ahmad/Liliyana Natsir, melangkah ke final Daihatsu Indonesia Masters 2018. Dalam laga semifinal di Istora Senayan, Jakarta, Sabtu (27/1/2018), unggulan utama ini menang atas rekannya yang juga penghuni Pelatnas Cipayung, Praveen Jordan/Melati Daeva Oktavianti.\r\n\r\nTontowi/Liliyana menang straight game atas pasangan baru yang diproyeksikan untuk menjadi pelapis mereka. Perang saudara ini berakhir dengan skor 22-20, 21-17.', '2018-01-27'),
(4, 2, 4, 'Ini Perempuan yang Membuat DPP PKPI Belum Lolos ', 'http://cdn0-a.production.images.static6.com/cRISOGelO5USLm6e2CxXK4PBONw=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1849520/original/060408000_1517223754-20180129_160431.jpg', 'Partai Keadilan dan Persatuan Indonesia (PKPI) dinyatakan belum lolos verifikasi faktual oleh KPU. Hal ini karena ada persyaratan yang belum dipenuhi oleh partai yang dipimpin mantan Kepala Badan Intelijen Negara A.M. Hendropriyono itu.\r\n\r\nMenurut Hendropriyono, partainya terganjal ketidakhadiran Ketua DPP PKPI bidang Buruh Emilia Kartini. Emilia absen karena ada masalah keluarga. Padahal KTP dan KTA sudah ada.', '2018-01-29'),
(5, 2, 4, 'Ke Afghanistan Pascateror, Jokowi Pakai Kendaraan Lapis Baja', 'http://cdn1-a.production.images.static6.com/Uqe3WkvKlXXjQ-SL_FCeNDW3ucg=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1849366/original/027627300_1517218768-jokowi_afghanistan.jpg', 'Pihak Istana memastikan keamanan Presiden Joko Widodo atau Jokowi tetap terjamin selama kunjungan kerja di Afghanistan. Menurutnya, pemerintah Afghanistan sudah memberikan pengamanan ekstra kepada Jokowi selama berada di negara tersebut.\r\n\r\nSekretaris Kabinet Pramono Anung pun membeberkan bagaimana pengamanan Jokowi yang baru saja sampai di Afghanistan. Menurut Pramono, sepanjang jalan dari bandara ke Istana Presiden Afghanistan, Jokowi menumpang kendaraan berlapis baja dengan dikawal 2 helikopter yang terbang di atas mobil Presiden.', '2018-01-29'),
(6, 1, 4, 'Kemendagri: 2 Nama Calon Penjabat Gubernur Baru Bersifat Usulan', 'http://cdn0-a.production.images.static6.com/3JalPHQm25snMoDiVAxlHaGa1gw=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1825395/original/002320200_1515491483-20180109-Mendagri-AY4.jpg', 'Dirjen Otonomi Daerah (Otda) Kementerian Dalam Negeri Sumarsono menegaskan, dua nama jenderal aktif Polri yang dikabarkan dicalonkan sebagai penjabat gubernur baru berupa usulan. Kewenangan penunjukan itu pun tidak seluruhnya berada di tangan Kemendagri.\r\n\r\n\"Sekali lagi, ini sifatnya usulan dan prosesnya dari tim hukum Kementerian Sekretaris Negara yang akan mengkaji lebih lanjut,\" terang pria yang karib disapa Soni itu dalam jumpa pers di kantornya, Senin (29/1/2018).', '2018-01-29'),
(7, 1, 5, 'Bill Gates Investasi Rp 546 Miliar untuk Kembangkan Sapi Super', 'http://cdn0-a.production.images.static6.com/mnURIPWnT1BLLB-y9YqOb8e98yw=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1075018/original/31c16d03ecafd5890ed190422aa7fec4ll-Gates-AFP-4.jpg', 'Bill Gates kembali melakukan aksi kemanusiaan untuk membantu banyak orang. Menurut laporan terbaru, miliarder tersebut akan berinvestasi 29 juta pound sterling (Rp 546 miliar) untuk membantu membiakkan sapi super.\r\n\r\nDikutip dari Mirror, Senin (29/1/2018), pembiakan sapi ini akan melibatkan ras sapi Inggris dan sapi Afrika. Nantinya, gen dari sapi Inggris akan ditanamkan ke DNA sapi Afrika untuk menghasilkan hewan yang lebih tangguh.', '2018-01-25'),
(8, 2, 5, 'Catat, Ini Pertolongan Pertama Saat Smartphone Terkena Air', 'http://cdn1-a.production.images.static6.com/DgrtvIiC6lROsmgapUbE4a1UL9Y=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1248263/original/094135500_1464511926-wetphone.jpg', 'Meski saat ini sudah ada smartphone yang dibekali sertifikat anti-air, jumlahnya masih belum terlalu banyak dan hanya ada di perangkat kelas high-end. Karenanya, air masih menjadi musuh utama dari pengguna perangkat pintar.\r\n\r\nBeragam cara pun dilakukan pengguna agar memastikan smartphone-nya tak terkena air. Namun, terkadang upaya tersebut tak selalu berhasil, ada kalanya perangkat kita dapat terkena air atau terjatuh dalam genangan air.', '2018-01-22'),
(9, 3, 6, 'Surat Cinta Untuk Starla The Movie Lewati 1 Juta Penonton', 'http://cdn0-a.production.images.static6.com/9YiN5w6L7HpIqtKtLkhdYCeTFYg=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1819332/original/002175800_1514976243-1__1_.jpg', 'Hingga hari ke-14, Film Surat Cinta Untuk Starla The Movie sudah disaksikan 1,1 juta penonton, tepatnya di angka 1.137.808. Angka psikologis box office film Indonesia sebesar 1 juta penonton pun dilewati.\r\n\r\nPenonton Surat Cinta Untuk Starla The Movie tak surut-surutnya menyaksikan film yang dibintangi Jefri Nichol dan Caitlin Halderman itu. Suasana menjelang berakhirnya libur sekolah pun masih tetap mewarnai kehadiran para penonton dari kalangan remaja.', '2018-01-11'),
(10, 3, 6, 'Masuki Petualangan Maze Runner lewat 4DX', 'http://cdn0-a.production.images.static6.com/5QRq8rGHaWSYQ6QCcR2xoJ9l-pA=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1844834/original/020034100_1516859060-maze_runner_2.jpg', ' Maze Runner: The Death Cure, film ketiga sekaligus terakhir dari seri Maze Runner, kini tengah ditayangkan di bioskop Tanah Air.\r\n\r\nFilm ketiga ini masih melanjutkan perjalanan Thomas (Dylan O\'Brien). Ia, Newt (Thomas-Brodie-Sangster), dan Frypan (Dexter Darden) adalah Gladers terakhir yang kebal terhadap virus Flare yang menjangkiti dunia.\r\n\r\nKetiganya mencoba menerobos kereta api milik WKCD demi menyelamatkan rekan mereka, Minho (Ki Hong Lee). Namun, mereka salah menaiki kereta dan Minho dibawa ke Last City, markas dari WKCD.', '2018-01-29'),
(11, 3, 1, 'Piala Presiden: Bali United Jinakkan Persija', 'http://cdn1-a.production.images.static6.com/9NkqOUtOrZXjxpKhBjuMHJDDhi8=/0x54:1200x730/640x360/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1849719/original/024089300_1517236164-Yabes_Roni.jpg', 'Bali United mengalahkan Persija Jakarta pada laga pamungkas Grup D Piala Presiden 2018. Serdadu Tridatu menang tipis 3-2 atas Macan Kemayoran di Stadion Kapten I Wayan Dipta, Gianyar, Senin (29/1/2018) malam WIB.\r\n\r\nDengan hasil ini, Bali United finis sebagai pemuncak klasemen dengan poin 9 hasil tiga laga. Sedangkan Persija harus puas di peringkat kedua dengan poin 6.\r\n\r\nMelawan Persija, Bali United menurunkan skuat yang berbeda. Jika pada dua laga sebelumnya para pemain muda yang tampil, kini skuat utama yang dimainkan, seperti Stefano Lilipaly, Kevin Brands, Yabes Roni, dan Ilija Spasojevic.', '2018-01-24'),
(12, 1, 3, 'Menghitung Hari, 5 Fakta Pernikahan Taeyang dan Min Hyo Rin', 'http://cdn0-a.production.images.static6.com/4qoLReHQTO-5JSN8QO0OCE6qWd4=/640x360/smart/filters:quality(75):strip_icc():format(webp)/liputan6-media-production/medias/1835030/original/010693600_1516176558-Taeyang.jpg', 'Sudah sekitar empat tahun Taeyang BigBang dan Min Hyo Rin menjalin hubungan asmara. Tentunya hal itu bukan perkara mudah, mengingat keduanya saat ini merupakan idola Korea yang tengah diganderungi dan memiliki kesibukan yang padat.\r\n\r\nSempat dikabarkan putus nyambung, Taeyang akhirnya mengumumkan rencana pernikahannya dengan sang kekasih di Instagram akhir Desember 2017 lalu. Taeyang mengaku sangat bahagia akan segera memasuki fase baru kehidupan bersama Min Hyo Rin.', '2018-01-29');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Olahraga'),
(3, 'Entertainment'),
(4, 'Politik'),
(5, 'Teknologi'),
(6, 'Movies');

-- --------------------------------------------------------

--
-- Table structure for table `komentar`
--

CREATE TABLE `komentar` (
  `id_komentar` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_isi` int(11) NOT NULL,
  `komentar` text NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `komentar`
--

INSERT INTO `komentar` (`id_komentar`, `id_user`, `id_isi`, `komentar`, `tanggal`) VALUES
(3, 1, 1, 'Bagussss', '2018-01-29'),
(4, 3, 1, 'Hmmm pertahanin dong', '2018-01-29');

-- --------------------------------------------------------

--
-- Table structure for table `reporter`
--

CREATE TABLE `reporter` (
  `id_reporter` int(11) NOT NULL,
  `nama_reporter` varchar(255) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reporter`
--

INSERT INTO `reporter` (`id_reporter`, `nama_reporter`, `alamat`, `tanggal_lahir`, `username`, `password`) VALUES
(1, 'Amalia Safira', 'Malang', '1998-01-25', 'amalia', '123'),
(2, 'Nurhalimah', 'Lombok', '1997-01-25', 'nurhalimah', '123'),
(3, 'Nadhifatul Laely', 'Malang', '1997-03-24', 'lely', '123');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama`, `alamat`, `tanggal_lahir`, `email`, `password`) VALUES
(1, 'Nakame Rhamadan', 'Malang', '1998-01-25', 'nakame@gmail.com', '123'),
(2, 'Nurhalimah', 'Malang', '1997-12-12', 'nur@gmail.com', '123'),
(3, 'Eka Daryanto', 'Sumenep', '1994-04-12', 'eka@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id_history`),
  ADD KEY `id_berita` (`id_isi`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `isi`
--
ALTER TABLE `isi`
  ADD PRIMARY KEY (`id_isi`),
  ADD KEY `id_reporter` (`id_reporter`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `komentar`
--
ALTER TABLE `komentar`
  ADD PRIMARY KEY (`id_komentar`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_isi` (`id_isi`);

--
-- Indexes for table `reporter`
--
ALTER TABLE `reporter`
  ADD PRIMARY KEY (`id_reporter`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id_history` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `isi`
--
ALTER TABLE `isi`
  MODIFY `id_isi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `komentar`
--
ALTER TABLE `komentar`
  MODIFY `id_komentar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `reporter`
--
ALTER TABLE `reporter`
  MODIFY `id_reporter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `isi`
--
ALTER TABLE `isi`
  ADD CONSTRAINT `isi_ibfk_1` FOREIGN KEY (`id_reporter`) REFERENCES `reporter` (`id_reporter`),
  ADD CONSTRAINT `isi_ibfk_3` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`);

--
-- Constraints for table `komentar`
--
ALTER TABLE `komentar`
  ADD CONSTRAINT `komentar_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `komentar_ibfk_2` FOREIGN KEY (`id_isi`) REFERENCES `isi` (`id_isi`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
