package post.controllers;

import post.models.ITransaction;

public interface IApplicationDelegate extends ITransaction {

    public void applicationWillBegin();
}
