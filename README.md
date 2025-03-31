# VeynosAdvancedFireballs

A Minecraft Plugin that allows you to throw fireballs and set a custom explosion radius with server performance in mind

![Version](https://img.shields.io/github/v/release/veynomc/veynosadvancedfireballs)
![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.4-brightgreen)

## Features

- Throwable Fireballs: just click a fireball and it will be thrown in the direction the player is facing and create an explosion upon impact
- configurability: configure the Fireball explosion radius with the command /fireballexplosionsize
- performance: This pLugin processes block changes asynchronously using FAWE to maintain excelent server performance even while chaning thousands of blocks

## Installation

1. Download the latest jar from the [Releases](https://github.com/veynoMC/veynosadvancedfireballs/releases) section
2. place the file in the `/plugins/` folder of your server
4. restart the Server or load the plugin

## Requirements

- This Plugin requires FAWE to be installed on the Server
- you can find the latest release [here](https://github.com/IntellectualSites/FastAsyncWorldEdit/releases)

## Commands

| Command | Description | Permission |
|--------|--------------|--------------|
| `//fireballexplosionsize` | sets the explosion radius of thrown fireballs | veynosadvancedfireballs.configure |


