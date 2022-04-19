# _Laboratory Work №5_
***
Enter the following to build and run the project:
~~~
mvn package
export path_to_file=<path to file>
java -jar .\target\lab5.jar path_to_file
~~~
Example of a valid XML file:
`InputCollection.xml`
~~~
<?xml version = "1.0" encoding = "UTF-8" ?>
<root>
    <HumanBeing id="177257">
        <name>Maksim</name>
        <coordinates>
            <x>14</x>
            <y>15.31</y>
        </coordinates>
        <creationDate>1650326579652</creationDate>
        <realHero>true</realHero>
        <hasToothpick>false</hasToothpick>
        <impactSpeed>412</impactSpeed>
        <weaponType>SHOTGUN</weaponType>
        <mood>APATHY</mood>
        <car>true</car>
    </HumanBeing>
</root>
~~~


