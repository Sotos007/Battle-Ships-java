# Battleship CLI - Java Edition ⚓

A classic strategic **Battleship** game implemented in Java. This is a command-line interface (CLI) application where the player attempts to locate and sink hidden ships on a 9x9 grid within a limited number of moves.

---

## 🚀 Features

* **Procedural Ship Placement:** Ships (Patrols and Cruisers) are randomly deployed at the start of every session using a custom collision-detection algorithm.
* **Dynamic Grid System:** Real-time visual feedback of the board showing hits, misses, and the fog of war.
* **Advanced Scoring Logic:**
    * Points for every successful hit.
    * Bonus points for completely sinking a Cruiser.
* **Result Analytics:** Post-game menu to review accuracy, total points, and specific ship-class destruction stats.
* **Input Validation:** Robust handling of coordinates and duplicate guesses.

---

## 🛠️ Requirements & Setup

### Prerequisites
* **Java Development Kit (JDK)** version 8 or higher.
* Any Terminal or Command Prompt.

### Installation & Execution
1.  **Clone or Download** the source code.
2.  **Navigate** to the project directory.
3.  **Compile** the program:
    ```bash
    javac Erg_1/Battleship.java
    ```
4.  **Run** the game:
    ```bash
    java Erg_1.Battleship
    ```

---

## 🎮 How to Play

### 1. Coordinates
The grid is a **9x9** matrix. When prompted, enter your guess as a two-digit integer:
* The first digit represents the **Row (r)**.
* The second digit represents the **Column (c)**.
* *Example:* Entering `45` targets **Row 4, Column 5**.

### 2. Ship Types
| Ship Type | Size | Quantity |
| :--- | :--- | :--- |
| **Patrol** | 1 Cell | 3 |
| **Cruiser** | 2 Cells | 3 |

### 3. Legend
* `B`: Blue Water (Unknown/Hidden)
* `M`: Missed shot
* `H`: Hit (Target confirmed)
* `S`: Ship (Revealed only at the end of the game)

---

## 📈 Scoring System

The game evaluates your performance based on the following:
* **Successful Hit:** +1 Point.
* **Sunk Cruiser:** +2 Bonus Points.
* **Total Moves:** You have a total of **10 guesses** per round.

---

## 📂 Project Structure
```text
.
├── Erg_1/
│   └── Battleship.java    # Main Game Logic
├── README.md              # Documentation
└── requirements.txt       # Environment specs
