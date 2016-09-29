## FunFin, Day #01!
The very project basement. Common stuff with CI, code coverage and smells control.
Simplest function and test for it.

### Repo creation
As simple as usual github repo generation, just opened 
[New Repo](https://github.com/new) page and populated repo name plus some
basic fields.

### Project init
[Gradle](https://gradle.org/) toolkit used for this with:
```shell
/data/projects/fun-fin $ gradle init --type scala-library
```
Gradle pre-populated project structure with sources/tests and minmal
imports has been generated then.

### Project integrations
There is must-have integrations trinity: continuous integration/coverage 
tracking/code smells monitoring. Supposed to be configured from commit #1.
All the integrations available over shortcuts into project ``readme`` header.

#### Continuous integration with Travis CI
Travis [CI integration](https://travis-ci.org/bearmug/fun-fin) 
is very straightforward. Travis config contained inside
self-explanatory ``.travis.yml`` file at project root folder:
```yaml
language: java

jdk:
  - oraclejdk8

# locations to cache for specific build
cache: 
 directories:
 - $HOME/.gradle/caches/
 - $HOME/.gradle/wrapper/

# speed-up build according to 
# https://dzone.com/articles/speed-up-gradle-build-on-travisci
install: echo "skip 'gradle assemble' step"
script: gradle build --continue

# code-coverage reporting
after_success:
  - gradle reportScoverage coveralls

```

#### Code coverage control with coveralls.io
As noted into Travis configuration, we report code coverage data to
[Coveralls service](https://coveralls.io/github/bearmug/fun-fin)
To do so, we need configure code coverage reporting. It is bloody
simple for Scala code under Gradle build system with [Scoverage]
(https://github.com/scoverage/gradle-scoverage) solution.
Two simple steps required to achieve such setup:
- activate coveralls Gradle plugin with 
[build.gradle](../build.gradle) file:
```groovy
plugins {
    ...
    id 'org.scoverage' version '2.1.0'
    ...
}
...
dependencies {
    ...
    scoverage 'org .scoverage:scalac-scoverage-plugin_2.11:1.1.0'
    scoverage 'org.scoverage:scalac-scoverage-runtime_2.11:1.1.0'
}
```
- configure Travis job to submit Coveralls report:
```yaml
...
after_success:
  - gradle reportScoverage coveralls
```

#### Code smells monitoring over codacy.com
[Cute dashboard](https://www.codacy.com/app/pavel-fadeev/fun-fin/dashboard) 
provided by codacy.com for free for any public project. No extra actions
required for project codebase, it is enough enable verification for
this repo directly at Codacy configuration page.


### Sample class and test 

