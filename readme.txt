Exemples de requétes:
    - mutation:
        Les mutations sont implémentés pour les joueurs et équipes:
        - team:
           python .\client.py --mutation --team --id "4" --name "ASC" --city "SaintEtienne"
        - player:
           python .\client.py --mutation --player --id "4" --name "Mares" --firstname "Ryan" --team_name "ManchesterCity" --position "Attaquant"
    - Query:
        Pour les query, ont peut mettre n'importe qu'elles arguments afin de filtre la requétes:
        - team: 
            python .\client.py --query --player --fields id name firstname position team
        - player: 
            python .\client.py --query --team --fields id name city
