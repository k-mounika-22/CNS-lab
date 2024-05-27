#include <stdio.h>
#include <string.h>
#include <stdbool.h>

void encryptRailFence(char *text, int key, char *cipher)
{
	char rail[key][strlen(text)];

	for (int i = 0; i < key; i++)
		for (int j = 0; j < strlen(text); j++)
			rail[i][j] = '\0';

	bool dir_down = false;
	int row = 0, col = 0;

	for (int i = 0; i < strlen(text); i++)
	{
		if (row == 0 || row == key - 1)
			dir_down = !dir_down;

		rail[row][col++] = text[i];

		dir_down ? row++ : row--;
	}

	int index = 0;
	for (int i = 0; i < key; i++)
		for (int j = 0; j < strlen(text); j++)
			if (rail[i][j] != '\0')
				cipher[index++] = rail[i][j];

	cipher[index] = '\0';
}

void decryptRailFence(char *cipher, int key, char *text)
{
	char rail[key][strlen(cipher)];

	for (int i = 0; i < key; i++)
		for (int j = 0; j < strlen(cipher); j++)
			rail[i][j] = '\0';

	bool dir_down;

	int row = 0, col = 0;

	for (int i = 0; i < strlen(cipher); i++)
	{
		if (row == 0)
			dir_down = true;
		if (row == key - 1)
			dir_down = false;

		rail[row][col++] = '*';

		dir_down ? row++ : row--;
	}

	int index = 0;
	for (int i = 0; i < key; i++)
		for (int j = 0; j < strlen(cipher); j++)
			if (rail[i][j] == '*' && index < strlen(cipher))
				rail[i][j] = cipher[index++];

	row = 0, col = 0;
	for (int i = 0; i < strlen(cipher); i++)
	{
		if (row == 0)
			dir_down = true;
		if (row == key - 1)
			dir_down = false;

		if (rail[row][col] != '*')
			text[i] = rail[row][col++];

		dir_down ? row++ : row--;
	}
	text[strlen(cipher)] = '\0';
}

int main()
{
	char text[100], cipher[100];
	printf("Enter the message: ");
	fgets(text, sizeof(text), stdin);
	text[strcspn(text, "\n")] = '\0';

	int key;
	printf("Enter the key: ");
	scanf("%d", &key);

	encryptRailFence(text, key, cipher);
	printf("Encrypted message: %s\n", cipher);

	char decrypted[100];
	decryptRailFence(cipher, key, decrypted);
	printf("Decrypted message: %s\n", decrypted);

	return 0;
}
