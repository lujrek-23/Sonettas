<div align="center">

  <h1>Sonettas</h1>

  <p align="center">
    <em>Pemutar musik untuk pendengar yang serius.</em>
  </p>

  <p align="center">
    <a href="#fitur"><b>Fitur</b></a> ·
    <a href="#desain"><b>Desain</b></a> ·
    <a href="#unduh"><b>Unduh</b></a>
  </p>

</div>

<hr/>

**Sonettas** adalah pemutar musik yang dibangun untuk pendengar yang serius. Bukan wrapper, bukan template. Streaming dari YouTube Music dengan 10 provider lirik, scrobbling Last.fm, dan animasi artwork Canvas. Dibangun oleh **Huanime Company**.

---

## Desain

Sonettas menggunakan estetika "Product-utility" — clean, functional, confident. Bukan editorial, bukan brutalist.

**Palet:**

| Warna | Hex | Penggunaan |
|-------|-----|------------|
| White | `#FFFFFF` | Latar utama |
| NearBlack | `#0A0A0A` | Teks utama |
| Orange | `#FF6B00` | Aksi primer, seleksi, state |
| Gray600 | `#525252` | Teks sekunder |
| Gray100 | `#F5F5F5` | Pembatas halus |

**Font:** Hanken Grotesk (single family, semua role)

**Logo:** Sonnet Wave — waveform yang membentuk huruf S.

---

## Fitur

**Pemutaran**
- YouTube Music streaming (anonymous atau login)
- Background listening, download untuk offline
- Crossfade, audio normalization (EBU R128)
- Sleep timer, equalizer

**Lirik**
- 10 provider lirik (LRCLib, KuGou, Paxsenix, BetterLyrics, dll)
- Word-by-word sync (TTML)
- Terjemahan dan romanisasi

**Pencarian**
- Search lagu, artis, album, playlist
- Search history, suggestions
- Local + online search

**Pustaka**
- 5 tab: Semua, Playlist, Lagu, Artis, Album
- Playlist management (create, reorder, import/export)
- Tag system, sort options

**Antarmuka**
- Material 3 dengan palet Restrained
- Font Hanken Grotesk
- minSdk 24 (Android 7.0+)
- No onboarding — langsung ke app
- Settings minimal (6 items, flat)

---

## Teknologi

- Kotlin + Jetpack Compose
- Media3 / ExoPlayer
- Room + Hilt + Ktor
- NewPipe Extractor (YouTube API)
- 10 Gradle modules
- 412 Kotlin files (app module)

---

## Build

```bash
git clone https://github.com/ahmdd4vd/sonettas.git
cd sonettas
./gradlew assembleGmsUniversalDebug
```

---

## Disclaimer

Sonettas adalah klien pihak ketiga yang independen. Tidak berafiliasi dengan Google LLC atau YouTube.

---

<div align="center">
<sub>Sonettas · Huanime Company · MMXXVI</sub>
</div>
