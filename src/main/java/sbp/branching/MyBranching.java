package sbp.branching;

import sbp.common.Utils;

public class MyBranching
{
    private final Utils utils;

    public MyBranching(Utils utils)
    {
        this.utils = utils;
    }

    /**
     * �� ���� ����� ���������� �������� unit-����
     * ���� ������ ��������� mock �� ������ {@link Utils} (���������� ����������)
     * ���������� ��������� ��������� ���������� ������ � ����������� �� ��������� ���������� {@link Utils}
     * @param i1 - ������ ��������
     * @param i2 - ������ ��������
     * @return - ������� �� �������� ��� 0, ���� Utils#utilFunc2 ����� true;
     */
    public int maxInt(int i1, int i2)
    {
        if (this.utils.utilFunc2())
        {
            for (int iter = 0; iter < i1; iter++)
            {
                do
                {
                    this.utils.utilFunc1("Hello");
                } while (iter < i2);
            }
            return 0;
        }

        int result = i1 >= i2 ? i1 : i2;
        return result;
    }

    /**
     * �� ���� ����� ���������� �������� unit-����
     * ���� ������ ��������� mock �� ������ {@link Utils} (���������� ����������)
     * ���������� ��������� ��������� ���������� ������ � ����������� �� ��������� ���������� {@link Utils}
     * @return - true, ���� Utils#utilFunc2() ���������� true
     */
    public boolean ifElseExample()
    {
        if (this.utils.utilFunc2())
        {
            System.out.println("True!");
            return true;
        }
        else
        {
            System.out.println("False!");
            return false;
        }
    }

    /**
     * �� ���� ����� ���������� �������� unit-����
     * ���� ������ ��������� mock �� ������ {@link Utils} (���������� ����������)
     * ���������� ��������� ���������� Utils#utilFunc1 � Utils#utilFunc2 ��� �������� i = 0
     * ���������� ��������� ���������� Utils#utilFunc1 � Utils#utilFunc2 ��� �������� i = 1
     * ���������� ��������� ���������� Utils#utilFunc1 � Utils#utilFunc2 ��� �������� i = 2
     * ����� ������� ��� �������� ����� ������, �� ����� ��� ������ �������� ������� �������� ����
     * @param i - �������� �������� (����� ���� �����)
     */
    public void switchExample(int i)
    {
        switch (i)
        {
            case 1:
                this.utils.utilFunc1("abc");

            case 2:
                this.utils.utilFunc2();
                break;

            default:
                if (this.utils.utilFunc2())
                {
                    this.utils.utilFunc1("abc2");
                }
        }
    }
}
