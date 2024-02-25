### Hexlet tests and linter status:
[![Actions Status](https://github.com/Maxonquall/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Maxonquall/java-project-71/actions)
<a href="https://codeclimate.com/github/Maxonquall/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/41afcdb9f857e2ee4374/maintainability" /></a>
![Java CI](https://github.com/Maxonquall/java-project-71/actions/workflows/main.yml/badge.svg)
<a href="https://codeclimate.com/github/Maxonquall/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/41afcdb9f857e2ee4374/test_coverage" /></a>

### Description:
CLI-app for comparing the contents of two configuration files. The result of the program is a comparison output in the format specified by the user.

### Supported file formats:
- .json;
- .yml.

### Supported result formats:
- stylish (default);
- plain;
- json.

### Install:
git@github.com:Maxonquall/java-project-71.git
cd java-project-71/app
make -C app build


## Setup

```bash
make -C app build
```
### Examples
### Difference between json files in stylish (by default):
[![Difer](https://asciinema.org/a/2IbNt7wZqowzHMxYO4CvA2PxV.svg)](https://asciinema.org/a/2IbNt7wZqowzHMxYO4CvA2PxV)
### Difference between yml files in stylish (by default):
[![Difer.yml](https://asciinema.org/a/hi8lnT1ZWDol2Km62OT5gA9fJ.svg)](https://asciinema.org/a/hi8lnT1ZWDol2Km62OT5gA9fJ)
### Difference between yml files with nested structures in stylish (by default):
[![Stylish](https://asciinema.org/a/ZCdNET9cPTopGJp58x7W3SZIY.svg)](https://asciinema.org/a/ZCdNET9cPTopGJp58x7W3SZIY)
### Difference between yml files with nested structures in plain:
[![Plain](https://asciinema.org/a/Qx1qXpj4QcNYwtZEl9OJlNOut.svg)](https://asciinema.org/a/Qx1qXpj4QcNYwtZEl9OJlNOut)
### Difference between json files with nested structures in json format:
[![Json](https://asciinema.org/a/w416zZHdYJcUnZTjhKKJUi8dV.svg)](https://asciinema.org/a/w416zZHdYJcUnZTjhKKJUi8dV)
