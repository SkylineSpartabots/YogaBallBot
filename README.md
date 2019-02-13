# Yoga Ball Bot

![](https://img.shields.io/github/contributors/SkylineSpartabots/YogaBallBot.svg?style=flat-square)
![](https://img.shields.io/github/languages/code-size/SkylineSpartabots/YogaBallBot.svg?style=flat-square)
![](https://img.shields.io/github/license/SkylineSpartabots/YogaBallBot.svg?style=flat-square)

The Spartabots' FRC robot code for our main outreach bot.

## Bot

The drive train is controlled by four Victors.  
The arm is controlled by controlled by four CANTalons.  
The roller is controlled by one Victor.

## Dancepad

Since this is an outreach bot, our "joystick" is a dancepad that looks like this:
```
| sel | sta |
| × | ↑ | O |
| ← |   | → |
| Δ | ↓ | □ |
```
The cross (×) rolls the ball in.  
The triangle (Δ) rolls the ball out.  
The circle (O) raises the arm (shoots the ball).  
The square (□) lowers the arm.

## Dashboard

We use ShuffleBoard for our dashboard. It has buttons and sliders for enabling and adjusting drive and shooter speed.

![ShuffleBoard for the Yoga Ball Bot](https://user-images.githubusercontent.com/14433542/52677678-bde70a80-2ee3-11e9-97ee-eb9d55db1ab0.png)

## Setup

1. Install the NI Update Suite and the WPILib Development Tools (+VS Code) ([Instructions][installation-instructions])
2. Install the libraries we use (CTRE Phoenix and NavX).
3. Make a new WPILib Java project and clone this repository

### Libraries
We use only one 3rd party library:
- [CTRE Phoenix][ctre-phoenix] (Currently using v5.12.0)

## Contributing
- Commit your changes to a feature branch, not to master, _especially if it is untested_
- Write [good][good-commit-message] commit messages
	- Written in sentence case (only first word capitalized)
	- Should complete the sentence: "If applied, this commit will _[Your commit message]_."
- Make sure each of your methods has a [Javadoc comment][javadoc-comment] and you comment liberally
- Maintain a consistent code style

[installation-instructions]: https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027504-installing-the-frc-update-suite-all-languages
[ctre-phoenix]: http://www.ctr-electronics.com/control-system/hro.html#product_tabs_technical_resources
[good-commit-message]: https://juffalow.com/other/write-good-git-commit-message
[javadoc-comment]: https://en.wikipedia.org/wiki/Javadoc#Structure_of_a_Javadoc_comment
