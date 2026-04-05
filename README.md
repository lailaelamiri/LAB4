#  FragmentsLab

An Android application built to learn and demonstrate dynamic Fragment navigation using `FragmentManager` and `FragmentTransaction`.

---

##  Screenshots & Demo

###  Player Fragment
> Displays the `PlayerFragment` with a 🎧 icon, "Choose a song..." text and a **▶ Play** button. The Logcat confirms `onResume — fragment is now visible`, proving the fragment lifecycle is working correctly.

![Player Screen](https://github.com/user-attachments/assets/66663143-ed33-498a-8295-cca6907d5cce)

---

###  Settings Fragment
> Displays the `SettingsFragment` with a volume **SeekBar** starting at 0 and the 🔇 emoji. The Logcat at the bottom shows both `onResume` and `onPause` firing as the user navigates between fragments — proof that the fragment lifecycle is fully functional.

![Settings Screen](https://github.com/user-attachments/assets/c112eee3-33d7-4b6f-ad16-96024132a957)

---

### 🎬 Demo Video
> Full demonstration of navigation between the two fragments — dynamic replacement via `FragmentTransaction`, Back button restoring the previous fragment thanks to `addToBackStack()`, and the Play/Pause toggle in action.

https://github.com/user-attachments/assets/9ca5649c-6b57-4628-88ab-573f29b62131

---

##  Project Structure

```
FragmentsLab/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/fragmentslab/
│   │       │   ├── MainActivity.java         # Host activity — manages fragment navigation
│   │       │   ├── PlayerFragment.java       # Fragment 1 — Play/Pause music UI
│   │       │   └── SettingsFragment.java     # Fragment 2 — Volume SeekBar with state saving
│   │       │
│   │       └── res/
│   │           └── layout/
│   │               ├── activity_main.xml     # Main layout with FrameLayout container
│   │               ├── fragment_player.xml   # Player fragment layout
│   │               └── fragment_settings.xml # Settings fragment layout
│   │
│   └── build.gradle
│
└── README.md
```

---

## Features

- Dynamic fragment loading inside a single Activity
- Navigation between fragments via top buttons
- Back stack support — Back button restores previous fragment
- Play/Pause toggle in `PlayerFragment`
- Volume SeekBar with emoji feedback in `SettingsFragment`
- State preservation across screen rotation using `onSaveInstanceState()`
- Fragment lifecycle logging via Logcat

---

##  Concepts Covered

| Concept | Description |
|---|---|
| `Fragment` | Reusable UI component with its own lifecycle |
| `FragmentManager` | Manages fragment operations inside an Activity |
| `FragmentTransaction` | Batch of fragment operations executed with `commit()` |
| `replace()` | Swaps current fragment with a new one |
| `addToBackStack()` | Saves transaction so Back button can undo it |
| `commit()` | Executes the transaction |
| `onViewCreated()` | Safe place to initialize views after inflation |
| `onSaveInstanceState()` | Saves data before fragment destruction (e.g. rotation) |
| `Bundle` | Key-value store for passing and saving data |

---

##  Setup

**Requirements**
- Android Studio Hedgehog or later
- Min SDK: API 24
- Language: Java

**Run the project**
1. Clone the repository
2. Open in Android Studio
3. Run on emulator or physical device (API 24+)

---
##  Key Files Explained

### `MainActivity.java`
The single host Activity. Contains the `FrameLayout` container and handles navigation by calling `switchPanel()` which uses `FragmentManager` to swap fragments.

### `PlayerFragment.java`
Displays a music player UI. Manages a boolean `isPlaying` state to toggle between Play and Pause. Implements `onResume()` and `onPause()` for lifecycle logging.

### `SettingsFragment.java`
Displays a volume SeekBar (0–100). Saves and restores the slider position across screen rotations using `onSaveInstanceState()` and a `Bundle`.

---

##  Lab Context

Built as part of an Android development lab focused on:
- Creating and using dynamic fragments
- Navigating between fragments with `FragmentManager`
- Managing events and states in fragments
- Understanding the fragment lifecycle

---

*Built with ❤️ using Java + Android Studio*
