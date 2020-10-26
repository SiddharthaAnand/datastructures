import logging
import build_utils

###################################################################
#                           BASE STAGE                            #
###################################################################
class Stages:
    def __init__(self, stage_name):
        self.stage_name = stage_name

    def __repr__(self):
        print("repr: [name:{0}]".format(__name__))

    def run(self):
        pass


###################################################################
#                       BUILD                                     #
###################################################################
class Build(Stages):
    __name__ = 'build'
    def __init__(self, stage):
        super().__init__(__name__)

    def run(self):
        pass


###################################################################
#                       TEST                                      #
###################################################################
class Test(Stages):
    def __init__(self):
        __name__ = 'test'
        super().__init__(__name__)

    def run(self):
        pass


###################################################################
#                         COMPILE                                 #
###################################################################
class Compile(Stages):
    _name = 'compile'

    def __init__(self, _files):
        super().__init__(stage_name=__name__)
        self._files = _files

    def compile(self):
        import os
        print('Setting current working directory\t{}'.format(os.getcwd()))
        try:
            for _dir in self._files:
                for _f in self._files[_dir]:
                    try:
                        if '.java' in _f:
                            os.system('javac {}'.format(_f))
                            print('Compiled {}'.format(_f))
                    except Exception as e:
                        #TODO Create a list of failed compiled files and print in the last.
                        continue
        except Exception as e:
            raise

    def run(self):
        print("running {}".format(Compile._name))
        #TODO Compile/Run then one by one
        self.compile()
        #TODO Use a logger
        print('Compilation done')

###################################################################
#                      STAGES RUNNER                              #
###################################################################
class StageRunner:
    def __init__(self, *args):
        """
        :param kwargs: dictionary of stages inheriting Stages class
        """
        assert args is not  None and len(args) != 0
        self.stages = [stage(args[1]) for stage in args[0]]
        self._files = args[1]

    def run(self):
        for stage in self.stages:
            stage.run()

    def validate(self):
        for stage in self.stages:
            stage.run()


###################################################################
#
###################################################################
if __name__ == '__main__':
    stage_runner = StageRunner([Compile], build_utils.get_dirs())
    stage_runner.run()