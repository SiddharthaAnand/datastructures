#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define ALPHABET_SIZE 26

struct trie
{
	struct trie *children[ALPHABET_SIZE];
	int isLeaf;
};


struct trie *getNode()
{
	int idx;
	struct trie *newNode = (struct trie *)malloc(sizeof(struct trie));
	if(newNode)
	{
		newNode->isLeaf = 0;
		for(idx = 0;idx < ALPHABET_SIZE; idx++)
		{
			newNode->children[idx] = NULL;
		}
	}
	return newNode;
}

void search(struct trie **root, char *key)
{
	struct trie *ptr = *root;
	int idx = 0;
	int length = strlen(key);

	while(idx < length)
	{
		if(ptr->children[key[idx] - 'a'])
			ptr = ptr->children[key[idx++] - 'a'];
		else
			break;
	}

	if(idx == (length - 1) && ptr->isLeaf)
		printf("%s : Key is present \n", key);
}


void insert(struct trie **root, char *key)
{
	struct trie *ptr = *root;
	int idx = 0;
	if(!root)
	{
		printf("ROOT IS NULL");
		return;
	}
	else
	{
		while(idx < strlen(key))
		{
			if(!ptr->children[key[idx] - 'a'])
			{
				ptr->children[key[idx] - 'a'] = getNode();
			}
			idx++;
		}
		ptr->isLeaf = 1;
		printf("Inserted\n");
	}
}



void test_search(struct trie **root)
{
	//test cases to test insert
	//struct trie *root = getNode();
	search(root, "apple");
	search(root, "app");
	search(root, "mango");
	search(root, "man");
	search(root, "theatre");
	search(root, "pineapple");
	search(root, "iphone");
}

void test_insert(struct trie **root)
{
	//test cases to test insert
	insert(root, "apple");
	insert(root, "app");
	insert(root, "mango");
	insert(root, "man");
	insert(root, "theatre");
	insert(root, "pineapple");
	insert(root, "iphone");

}


int main()
{
	struct trie *root = getNode();
	test_insert(&root);
	test_search(&root);
}	
