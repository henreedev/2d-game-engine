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
| Requirement                                                                                                                                                                                                                       | Location in code or steps to view in game             |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------|
| Your handin must meet all global requirements                                                                                                                                                                                     | Yes (see this completed README and INSTRUCTIONS file) |
| Your handin only crashes under exceptional circumstances (edge cases)                                                                                                                                                             | Doesn't crash afaik                                   |
| The engine must have a “viewport” UI element that draws the GameWorld from a different coordinate system onto the screen coordinate system. The viewport must support panning (translation of the currently viewable game state). | `engine/Viewport.java`                                |
| Your engine must have a System class that contains GameObjects.                                                                                                                                                                   | `engine/GameSystem.java`                              |
| Your engine must have a class representing the game world. That class must hold at least one system.                                                                                                                              | `engine/GameWorld.java`                               |
| The viewport should be visible once the game is run (either directly or through a menu). The player must be able to pan the viewport (the viewport cannot display a solid color).                                                 | `alc/AlcScreen:15`, `alc/Viewport.pan`                |
| There must be a “unit” visible in the viewport.                                                                                                                                                                                   | `alc/AlcWorld.setupWorld()`                           |
| The “unit” must respond to being clicked (only when the unit itself is clicked).                                                                                                                                                  | `alc/AlcUnit.onMouseClicked()`                        |
| The “unit” must be able to be dragged freely.                                                                                                                                                                                     | `alc/AlcUnit.onMouseDragged()`                        |
| The “unit” should be drawn and moved using separate components.                                                                                                                                                                   | `alc/AlcUnit:110`                                     |


## Secondary Requirements:
| Requirement                                                                                                                                                                                                                                   | Location in code or steps to view in game |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| Your engine must meet all primary engine requirements                                                                                                                                                                                         | ```Shown above```                         |
| The viewport must support zooming (scaling of the currently viewable GameState). When zooming, the viewport must either keep the center of the game in the same position or keep the location currently under the mouse in the same position. | ```engine/Viewport.onZoom()```            |
| Your game must meet all primary game requirements.                                                                                                                                                                                            | See above~                                |
| The player must be able to zoom the map (make sure the unit still responds to being clicked!).                                                                                                                                                | ```engine/Viewport.onMouseScrolled()```   |
| There must be a menu from which the player can make a copy of a “unit” by clicking and dragging it, without the original being destroyed or moved.                                                                                            | Shown in demo                             |

[//]: # (## Extras:)

[//]: # (| Requirement | Location in code or steps to view in game  |)

[//]: # (|---|---|)

[//]: # (| [Copy and paste from handout] | ```File path, function name, or steps to replicate``` |)

--------------------------------------------------------------

Instructions on how to run:
1. Install javafx in root folder as described in handout
2. Run alc/Main.java

Known bugs:
1. zooming is wonky
Hours spent on assignment: ~15
