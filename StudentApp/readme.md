To execute the Build provide the below Maven Goal:
clean verify serenity:aggregate

To execute Tagged tests, provide the goal as shown in the below format
clean verify -Dtags="studentfeature:NEGATIVE,studentfeature:SMOKE" serenity:aggregate