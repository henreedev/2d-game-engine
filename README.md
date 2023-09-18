# TIC Handin README
#### Fill out this README before turning in this project. Make sure to fill this out again for each assignment!

### Banner ID:
B01569554
### Already uploaded demo onto Slack:
Yes
### Git Repository Link:
https://github.com/BrownCSCI1950N/2d-game-engines-2023-stencil-bobertsanchezez
### Git commit hash:
idk how to put that here without committing this file first
## Primary Requirements:
| Requirement                                                                                                                                                                                                                                                                                                                                                                                                                                  | Location in code or steps to view in game                         |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|
| Your handin must meet all global requirements                                                                                                                                                                                                                                                                                                                                                                                                | Yes (see this completed README and INSTRUCTIONS file)             |
| Your handin only crashes under exceptional circumstances (edge cases)                                                                                                                                                                                                                                                                                                                                                                        | Doesn't crash afaik                                               |
| Your engine must draw the current screen on every “draw” event (originating from support code). Each screen must be able to define the way in which it is drawn independently from other screens                                                                                                                                                                                                                                             | ```engine/Application.onDraw()```                                 |
| Your engine must be able to process mouse events (originating from support code) and allow each screen to define how they are handled                                                                                                                                                                                                                                                                                                        | ```engine/Application.onMouseClicked()``` (and those below)       |
| Your engine must be able to process keyboard events (originating from the support code) and allow each screen to define how they are handled                                                                                                                                                                                                                                                                                                 | ```engine/Application.onKeyTyped()``` (and those below)           |
| Your current screen must update itself on every “tick” event (originating from the support code)                                                                                                                                                                                                                                                                                                                                             | ```engine/Application.onTick()```                                 |
| Your engine must be able to process resizable windows (originating from support code) and adjust the internal state when the draw area is resized. It must also ensure that size information is preserved when the current screen changes – if the current screen changes after a resize event, the new current screen must be aware of the correct window size as well                                                                      | ```engine/Application.onResize(), engine/Screen.onResize()```     |
| Your engine should have a basic UI toolkit. At a minimum, this toolkit should allow a game to display text and rectangles                                                                                                                                                                                                                                                                                                                    | ```engine/uitoolkit/*```                                          |
| Your engine must have a correct and easily extensible implementation of a button                                                                                                                                                                                                                                                                                                                                                             | ```engine/uitoolkit/Button.java```                                |
| Your handin must meet all playtesting requirements                                                                                                                                                                                                                                                                                                                                                                                           | see demo in #demos (Henry Earnest)                                |
| A 3x3 square board must be accessible from the screen once the application is run (either directly or through a menu)                                                                                                                                                                                                                                                                                                                        | ```tic/TicScreen:36, tic/assets/Board.java```                     |
| An X or an O must appear on a box when that box is clicked                                                                                                                                                                                                                                                                                                                                                                                   | ```tic/assets/BoardSlotBehavior:24```                             |
| Your game must implement the rules of Tic-Tac-Toe: two players, X and O, take turns marking squares on a 3x3 grid with their respective symbols. If a player succeeds in placing three symbols in a horizontal, vertical, or diagonal row, that player wins. If all the squares are filled without either player completing a row, the game is a draw. Both players can be human players: you do not need an AI opponent for this assignment | ```tic/assets/BoardSlotBehavior.doOnClick()```                    |
| Have at least two screens: an in-game screen and another screen, such as a title screen                                                                                                                                                                                                                                                                                                                                                      | ```tic/App:23, 24```                                              |
| Clearly display which player’s turn it is                                                                                                                                                                                                                                                                                                                                                                                                    | ```tic/assets/TurnText.tick()```                                  |
| At the end of the game, effectively communicate which player won, or if it was a draw                                                                                                                                                                                                                                                                                                                                                        | ```tic/assets/TurnText.tick(), tic/TicScreen.gameEndSequence()``` |
| Display the state of the game on a square board that scales with window size. The board must remain square at all times, no matter the window’s aspect ratio                                                                                                                                                                                                                                                                                 | ```tic/assets/Board.resize()```                                   |
| Your game must implement keyboard events (e.g., exit game on escape)                                                                                                                                                                                                                                                                                                                                                                         | ```tic/App.onKeyPressed()```                                      |
| Your game must never crash.                                                                                                                                                                                                                                                                                                                                                                                                                  | Doesn't crash                                                     |


## Secondary Requirements:
| Requirement                                                                                                                                                    | Location in code or steps to view in game                                                     |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| Your engine must meet all primary engine requirements                                                                                                          | ```Shown above```                                                                             |
| Your buttons should display differently when they are hovered                                                                                                  | ```engine/uitoolkit/ButtonBehavior.doOnHover(), tic/assets/BoardSlotBehavior.doOnHover()```   |
| Each player’s turn should have a time limit. If the player does not make a move when the time expires, it becomes the other player’s turn and the timer resets | ```tic/assets/Timer.tick(), .adjustTimeVal()```                                               |
| Show the countdown timer (e.g., shrinking bar, text in seconds)                                                                                                | ```tic/assets/TimerText.java, tic/assets/Timer:32```                                          |
| It must be possible to start a new game without restarting the program                                                                                         | ```tic/assets/StartButtonBehavior.doOnClick()```(just re-open menu using 'r' and click button |

[//]: # (## Extras:)

[//]: # (| Requirement | Location in code or steps to view in game  |)

[//]: # (|---|---|)

[//]: # (| [Copy and paste from handout] | ```File path, function name, or steps to replicate``` |)

--------------------------------------------------------------

Instructions on how to run:
1. Install javafx in root folder as described in handout
2. Run tic/Main.java

Known bugs: 
1. Brief flash of board with both X and O on all slots at start of program
2. FPS is low (~35) (apparently not a bug)
3. Final X or O is ghosted
4. Resizing by using the "fullscreen" button in the top right doesn't trigger a resize
5. Game starts slightly incorrectly sized; line of white pixels on the bottom

Hours spent on assignment: ~25
