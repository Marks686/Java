#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

#define getpch(type) (type*)malloc(sizeof(type))
#define NULL 0
#define TIME 2//ʱ��Ƭ����

typedef struct pcb {//���̹����
	char name[10];//��������
	char state;		//����״̬
	int queue;		//�������ڵĶ���
	int ntime;		//������Ҫ���е�ʱ��
	int rtime;		//�����Ѿ����е�ʱ��
	int etime;		//�����ڱ����п����е�ʱ��Ƭ
	struct pcb* link;
}PCB;

PCB* ready = NULL, * pinsert = NULL, * pfend = NULL, * p = NULL;	 //�������У����̲���λ�õı���

int geti()	//ʹ�û�������������
{
	char ch;
	int i = 0;
	fflush(stdin);
	ch = getchar();
	while (ch == '\n') {
		fflush(stdin);
		ch = getchar();
	}
	while (ch != '\n') {
		if (ch > '9' || ch < '0') {
			printf("\t��������!!����ֻ��Ϊ������������������...\n");
			fflush(stdin);
			i = 0;
			ch = getchar();
		}
		else {
			i = i * 10 + (ch - '0');
			ch = getchar();
		}
	}
	return i;
}

void findpos()//����״̬��
{
	PCB* ps = pfend;
	if (!ps || !ps->link || (ps->link->queue - ps->queue) > 1)
		pinsert = ps;
	else {
		while (ps->link && ps->link->queue != (pfend->queue + 2))
			ps = ps->link;
		pinsert = ps;


	}
}

void insert()//�������
{
	if (!ready) {

		ready = p;
		pfend = p;
		pinsert = p;
	}
	else if (ready->queue == 1) {//��һ���д���
		p->link = pfend->link;
		pfend->link = p;
		pfend = p;
		findpos();
	}
	else {
		p->link = ready;
		ready = p;
		findpos();
	}

}

void input()/*�������̿��ƿ麯��*/
{
	int i, num;

	printf("\n��������̵ĸ���?");
	num = geti();
	for (i = 0; i < num; i++)
	{
		printf("\n���̺�No.%d:\n", i + 1);
		p = getpch(PCB);
		printf("\n���������:");
		scanf("%s", p->name);
		printf("�����������ʱ��:");
		p->ntime = geti();
		printf("\n");
		p->rtime = 0;
		p->state = 'w';
		p->queue = 1;
		p->etime = TIME;
		p->link = NULL;
		insert();/*����insert����*/
	}
}

void disp(PCB* pr)  /*����������ʵ������������ʾ��ǰ����*/
{
	printf("\nname\t state\t queue\t ntime\t rtime\t�ڶ��п�ͣ��ʱ��\t \n");
	printf("|%s\t", pr->name);
	printf(" |%c\t", pr->state);
	printf(" |%d\t", pr->queue);
	printf(" |%d\t", pr->ntime);
	printf(" |%d\t", pr->rtime);
	printf(" |%d\t", pr->etime);
	printf("\n");
}

void check()/*�������̲鿴����*/
{
	PCB* pr;
	printf("\n ****��ǰ�������еĽ�����:%s", ready->name);/*��ʾ��ǰ���еĽ���*/
	disp(ready);
	pr = ready->link;
	printf("\n****��ǰ��������״̬Ϊ:\n");/*��ʾ��������״̬*/
	while (pr != NULL)
	{
		disp(pr);
		pr = pr->link;
	}
}


void sort()//�������̶���
{
	if (!ready->link || ready->queue < ready->link->queue) return;

	p = ready->link;
	ready->link = pinsert->link;
	pinsert->link = ready;
	pinsert = ready;
	ready = p;
	if (ready && ready->queue == pinsert->queue) {
		findpos();
	}

}

void addnew()//����µĽ���
{
	if (ready->queue != 1) {
		(ready->queue)++;
		ready->etime *= 2;
		ready->state = 'w';
		sort();/*����sort����*/
		input();
	}
	else {
		input();

	}

}
void destroy()/*�������̳�������(�������н�������������)*/
{
	printf("\n����[%s]�����.\n", ready->name);
	p = ready;
	ready = ready->link;
	free(p);
	if (ready && ready->queue == pinsert->queue)
		findpos();
}


void running()/*�������̾�������(��������ʱ�䵽���þ���״̬)*/
{
	(ready->rtime)++;
	ready->etime--;
	if (ready->rtime == ready->ntime) {
		destroy();
		return;
	}
	else if (ready->etime == 0) {
		int time = 2;
		(ready->queue)++;
		for (int i = 2; i != ready->queue; ++i)
			time *= 2;
		ready->etime = time;
		ready->state = 'w';
		sort();/*����sort����*/
	}
}


void main()
{
	char ch;
	input();
	while (ready != NULL)
	{
		printf("\nThe execute name:%s\n", ready->name);
		ready->state = 'R';
		check();
		running();
		printf("\n��i������½���....�������������������...");
		fflush(stdin);
		ch = getchar();
		if (ch == 'i' || ch == 'I')
			addnew();

	}
	printf("\n\n �����Ѿ����\n");
	system("pause");
}
