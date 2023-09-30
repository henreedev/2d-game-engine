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

## Primary Engine Requirements:
| Requirement                                                                                                                               | Location in code or steps to view in game             |
|-------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------|
| Your handin must meet all global requirements                                                                                             | Yes (see this completed README and INSTRUCTIONS file) |
| Your handin only crashes under exceptional circumstances (edge cases)                                                                     | Doesn't crash afaik                                   |
| Your engine must support collision detection between points, circles, and AABs. This includes a collision system and collision behaviors. | `engine/systems/CollisionSystem.java`                 |

## Primary Game Requirements:
| Requirement                                                                                                                                                                 | Location in code or steps to view in game                               |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------|
| Your game should display at least 2 “units” in your viewport.                                                                                                               | `alc/AlcWorld.setupWorld()`                                             |
| The player should be able to move the “units” around the screen.                                                                                                            | `alc/AlcUnit.onMouseDragged()`                                          |
| The “units” should have sprites.                                                                                                                                            | `alc/AlcUnit:48`                                                        |
| You must have at least 2 base “units”/elements, which can be combined to form a new element.                                                                                | `alc/AlcWorld.setupWorld()`, `alc/assets/AlcType.java`                  |
| You must be able to add elements to the work-space by dragging them from the menu.                                                                                          | `alc/AlcUnit.onMouseDragged()`                                          |
| Your game must complete the debugger. Using the debugger, the TAs should quickly be able to verify collisions between any pair of the following: points, circles, and AABs. | `debugger/support/Display.java` or see `debugger/collisions/Week2.java` |


## Secondary Engine Requirements:
| Requirement                                           | Location in code or steps to view in game                                                                                                                                                               |
|-------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Your engine must meet all primary engine requirements | ```Shown above```                                                                                                                                                                                       |
| Your engine must include a sprite component.          | ```engine/components/GraphicsComponent``` is all I use for drawing. See `engine/resource/SpriteResource.java`; sprite drawing functionality is stored in the Resource that initializes the spritesheet. |
| Sprites should only be loaded once.                   | `alc/AlcWorld.onStartup()`                                                                                                                                                                              |

## Secondary Game Requirements:
| Requirement                                                                                                                                                                                                                                                                        | Location in code or steps to view in game                              |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------|
| Your game must meet all primary game requirements.                                                                                                                                                                                                                                 | See above~                                                             |
| You must be able to remove elements from the work-space by dragging them to the menu or some sort of “trash” area.                                                                                                                                                                 | ```alc/AlcUnit:151```                                                  |
| You must have at least 4 base “units”/elements and at least 3 “units”/elements the player can make through combinations, one of which must be made by combining two non-base “units”/elements, and one of which must be a final “unit”/element (cannot be combined with anything). | `alc/AlcUnit:124` and below explains how each of the 7 units are made. |

[//]: # (## Extras:)

[//]: # (| Requirement | Location in code or steps to view in game  |)

[//]: # (|---|---|)

[//]: # (| [Copy and paste from handout] | ```File path, function name, or steps to replicate``` |)

--------------------------------------------------------------

Instructions on how to run:
1. Install javafx in root folder as described in handout
2. Run alc/Main.java

Known bugs:
1. zooming is still wonky
2. Draw order is inconsistent (sometimes a certain element will draw under the trash, and sometimes it won't)
Hours spent on assignment: ~15
