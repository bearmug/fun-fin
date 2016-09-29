## FunFin, Day #01!
The very project basement. Common stuff with CI, code coverage and smells control.
Simplest function and test for it.

### Repo creation
As simple as usual github repo generation, just opened 
[New Repo](https://github.com/new) page and populated repo name and some
basic fields.

### Project init
[Gradle](https://gradle.org/) toolkit used for this with:
```shell
/data/projects/fun-fin $ gradle init --type scala-library
```
Gradle pre-populated project structure with sources/tests and minmal
imports has been generated then.

### Project integrations
There is must-have Github integrations trinity. 
It is not about specific services, but about those ones types.
It is really mandatory to obtain CI/coverage tracking and code smells monitoring
from commit #1.

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
(https://github.com/scoverage) solution.

#### Code smells monitoring over codacy.com

### Sample class and test 
