import logging

class Stages:
    def __init__(self, stage_name):
        self.stage_name = stage_name

    def __repr__(self):
        print("repr: [name:{0}]".format(__name__))


class Build(Stages):
    pass


class Test(Stages):
    pass


class Compile(Stages):
    pass


class StageRunner:
    def __init__(self, **kwargs):
        pass

