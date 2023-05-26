import requests
import argparse

url = 'http://localhost:8080/graphql' 

#déclaration de la mutation insérer un joueur
mutation_query_player = '''
    mutation WritePlayer($id: String!, $name: String!, $firstname: String!, $team: String!, $position: String) {
        writePlayer(id: $id, name: $name, firstname: $firstname, team: $team, position: $position) {
            id
            name
            firstname
            team
            position
        }
    }
'''
#déclaration de la mutation insérer une equipe
mutation_query_team = '''
    mutation WriteTeam($id: String!, $name: String!, $city: String) {
        writeTeam(id: $id, name: $name, city: $city) {
            id
            name
            city
        }
    }
'''
#déclaration de la query pour chercher des informations sur tous les joueurs
query_player = '''
    query AllPlayers {
        allPlayers {
            %s
        }
    }
'''
#déclaration de la query pour chercher des informations sur toutes les équipes
query_team = '''
    query AllTeams {
        allTeams {
            %s
        }
    }
'''

# Analyse des arguments du script
parser = argparse.ArgumentParser()
parser.add_argument('--mutation', action='store_true')
parser.add_argument('--query', action='store_true')
parser.add_argument('--id')
parser.add_argument('--name')
parser.add_argument('--firstname')
parser.add_argument('--team_name')
parser.add_argument('--team', action='store_true')
parser.add_argument('--player', action='store_true')
parser.add_argument('--position')
parser.add_argument('--city')
parser.add_argument('--fields', nargs='+')
args = parser.parse_args()


# Construction du dictionnaire de variables pour la mutation joueur
mutation_variables_player = {
    'id': args.id,
    'name': args.name,
    'firstname': args.firstname,
    'team': args.team_name,
    'position': args.position
}
# Construction du dictionnaire de variables pour la mutation équipe
mutation_variables_team = {
    'id': args.id,
    'name': args.name,
    'city': args.city

}

if args.mutation:#lancement requéte de type mutation
    if args.player:#lancement requéte de type mutation pour joueur
        query = mutation_query_player
        variables = mutation_variables_player
        response = requests.post(url, json={'query': query, 'variables': variables})
        data = response.json()
    elif args.team:#lancement requéte de type mutation pour équipe
        query = mutation_query_team
        variables = mutation_variables_team
        response = requests.post(url, json={'query': query, 'variables': variables})
        data = response.json()        
else:#lancement requéte de type query
    fields_query = ' '.join(args.fields)
    if args.team:#lancement requéte de type query pour équipe
        query = query_team % fields_query
        response = requests.post(url, json={'query': query})
        data = response.json()
    elif args.player:#lancement requéte de type query pour joueur
        query = query_player % fields_query
        response = requests.post(url, json={'query': query})
        data = response.json()
# Vérification de la réponse
if 'errors' in data:#réponse erreur
    print('Erreur lors de l\'exécution de la requête GraphQL :')
    for error in data['errors']:
        print(error['message'])
else:
    if (args.mutation and args.player):#réponse pour mutation joueur
        player = data['data']['writePlayer']
        print('Joueur créé avec succès:')
        print('---')
        print('ID:', player['id'])
        print('Nom:', player['name'])
        print('Prénom:', player['firstname'])
        print('Équipe:', player['team'])
        print('Poste:', player['position'])
    elif (args.mutation and args.team):#réponse pour mutation équipe
        team = data['data']['writeTeam']
        print('Team créé avec succès:')
        print('---')
        print('ID:', team['id'])
        print('Nom:', team['name'])
        print('city:', team['city'])    
    else:
        if args.player:#réponse pour query joueur
            results = data['data']['allPlayers']
            print('Liste des joueurs:')
            for result in results:
                print('---')
                for field in args.fields:
                    print(f'{field}: {result.get(field)}')
        if args.team:#réponse pour query equipe
            results = data['data']['allTeams']
            print('Liste des équipes:')
            for result in results:
                print('---')
                for field in args.fields:
                    print(f'{field}: {result.get(field)}')        